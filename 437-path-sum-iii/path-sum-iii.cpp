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

    int count=0;
    int target;
    unordered_map<long long,long long> map;
    void dfs(TreeNode* root,long long prefixSum)
    {
        if(root==NULL)
        return;

        prefixSum+=root->val;

        if(map.count(prefixSum-target)>0)    
        count+=map[prefixSum-target];

        map[prefixSum]++;

        dfs(root->left,prefixSum);
        dfs(root->right,prefixSum);

        // backtracking
        map[prefixSum]--;
        if(map[prefixSum]==0)
        map.erase(prefixSum);
    }

    int pathSum(TreeNode* root, int targetSum) 
    {
        if(root==NULL)
        return 0;

        target=targetSum;
        map[0]=1;
        
        dfs(root,0);
        return count;
    }
};