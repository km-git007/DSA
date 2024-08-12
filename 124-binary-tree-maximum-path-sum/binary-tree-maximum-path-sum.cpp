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
    int maxSum=INT_MIN;
    int solve(TreeNode* root)
    {
        if(root==NULL)
        return 0;

        int Left=solve(root->left);
        int Right=solve(root->right);

        int phle_hi_milagaya=Left+Right+root->val;
        int ek_accha_hai=max(Left,Right)+root->val;
        int root_accha_hai=root->val;

        maxSum=max({maxSum,phle_hi_milagaya,ek_accha_hai,root_accha_hai});
        return max(ek_accha_hai,root_accha_hai);
    }

    int maxPathSum(TreeNode* root) 
    {
        solve(root);
        return maxSum;
    }
};