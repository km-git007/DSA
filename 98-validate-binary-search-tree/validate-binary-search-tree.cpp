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
    long prev=LONG_MIN;
    bool solve(TreeNode* root)
    {
        if(!root)
        return true;

        bool Left=solve(root->left);
        if(!Left)
        return false;

        if(prev>=root->val)
        return false;

        prev=root->val;

        return solve(root->right);
    }

    bool isValidBST(TreeNode* root) 
    {
        return solve(root);
    }
};