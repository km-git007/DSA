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
    vector<TreeNode*> ans;
    TreeNode* solve(TreeNode* root, unordered_set<int> set)
    {
        if(!root)
        return NULL;

        root->left=solve(root->left,set);
        root->right=solve(root->right,set);

        if(set.count(root->val))
        {
            if(root->left)
            ans.push_back(root->left);

            if(root->right)
            ans.push_back(root->right);

            delete root;
            return NULL;
        }
        return root;
    }

    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) 
    {
        unordered_set<int> set;
        for(int i=0;i<to_delete.size();i++)
        set.insert(to_delete[i]);

        if(!set.count(root->val))    // adding the main root of the tree
        ans.push_back(root);

        solve(root,set);
        return ans;
    }
};