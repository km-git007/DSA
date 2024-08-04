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

    vector<int> postorderTraversal(TreeNode* root) 
    {
        vector<int> ans;

        if(!root)
        return ans;
        
        stack<TreeNode*> s;
        s.push(root);
        while(!s.empty())
        {
            TreeNode* curr=s.top();
            s.pop();

            ans.push_back(curr->val);

            if(curr->left)
            s.push(curr->left);

            if(curr->right)
            s.push(curr->right);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};