/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    unordered_map<int,int> map;
    int maxFrequency=0;
    int solve(TreeNode* root)
    {
        if(!root)
        return 0;

        int sum = root->val;
        sum += solve(root->left);
        sum += solve(root->right);

        map[sum]++;
        maxFrequency=max(maxFrequency,map[sum]);
        
        return sum;
    }

    vector<int> findFrequentTreeSum(TreeNode* root) 
    {
        vector<int> ans;
        solve(root);

        for(auto x : map)
        {
            if(x.second==maxFrequency)
            ans.push_back(x.first);
        }
        return ans;
    }
};