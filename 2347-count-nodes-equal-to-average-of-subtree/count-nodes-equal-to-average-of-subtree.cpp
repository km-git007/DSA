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

    int result=0;
    pair<int,int> solve(TreeNode* root,int sum,int count)
    {
        if(!root)
        return {0,0};

        pair<int,int> Left=solve(root->left,sum,count);
        pair<int,int> Right=solve(root->right,sum,count);

        sum=root->val+Left.second+Right.second;
        count=1+Left.first+Right.first;

        if(sum/count==root->val)
        result++;

        return {count,sum};
    }

    int averageOfSubtree(TreeNode* root) 
    {
        solve(root,0,0);
        return result;
    }
};