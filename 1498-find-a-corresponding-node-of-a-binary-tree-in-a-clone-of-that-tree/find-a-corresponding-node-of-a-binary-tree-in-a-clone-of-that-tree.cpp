/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* solve(TreeNode* root, TreeNode* target)
    {
        if(!root)
        return NULL;

        if(root->val==target->val)
        return root;

        TreeNode* Left=solve(root->left,target);
        TreeNode* Right=solve(root->right,target);

        if(Left==NULL && Right==NULL)
        return NULL;

        return (Left!=NULL)?Left:Right;
    }

    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) 
    {
        return solve(cloned,target);
    }
};