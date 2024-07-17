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
    pair<int,TreeNode*> dfs(TreeNode* root)
    {
        if(root==NULL)
        return {0,NULL};

        pair<int,TreeNode*> leftPart=dfs(root->left);
        pair<int,TreeNode*> rightPart=dfs(root->right);
        int L= leftPart.first;
        int R= rightPart.first;

        if(L==R)  
        return {L+1,root};

        else if(L>R)
        return{L+1,leftPart.second};
        
        return {R+1,rightPart.second};
    }

    TreeNode* subtreeWithAllDeepest(TreeNode* root) 
    {
        return dfs(root).second;
    }
};