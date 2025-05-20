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
    TreeNode* LCA(TreeNode* root,TreeNode* p, TreeNode* q)
    {
	    if(root==NULL)
	    return NULL;

	    TreeNode* L=LCA(root->left,p,q);	
	    TreeNode* R=LCA(root->right,p,q);

	    if((L && R) || root->val==p->val || root->val==q->val)
	    return root;

	    return (L==NULL)?R:L;
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
    {
        return LCA(root,p,q);
    }
};