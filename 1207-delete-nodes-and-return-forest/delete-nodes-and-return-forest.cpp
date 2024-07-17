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
    TreeNode* solve(TreeNode* root, unordered_map<int,bool> map)
    {
        if(!root)
        return NULL;

        root->left=solve(root->left,map);
        root->right=solve(root->right,map);

        if(map[root->val])
        {
            if(!root->left && !root->right)  // Leaf Node.
            return NULL;

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
        unordered_map<int,bool> map;
        for(int i=0;i<to_delete.size();i++)
        map[to_delete[i]]=true;

        if(!map[root->val])    // adding the main root of the tree
        ans.push_back(root);

        solve(root,map);
        return ans;
    }
};