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
private:
    unordered_map<int, int> map;   
    TreeNode* solve(vector<int>& preorder, vector<int>& postorder, int preStart, int preEnd, int postStart) 
    {
        if (preStart > preEnd) 
        return nullptr;
        
        TreeNode* node = new TreeNode(preorder[preStart]);
        
        if (preStart == preEnd) 
        return node;
        
        int pos = map[preorder[preStart + 1]];
        int numLeftTree = pos - postStart + 1;
        
        node->left = solve(preorder, postorder, preStart + 1, preStart + numLeftTree, postStart);
        node->right = solve(preorder, postorder, preStart + numLeftTree + 1, preEnd, pos + 1);
        
        return node;
    }

public:
    TreeNode* constructFromPrePost(vector<int>& preorder, vector<int>& postorder) 
    {
        int n = postorder.size();
        for(int i = 0; i < n; i++) 
        map[postorder[i]] = i;
        
        return solve(preorder, postorder, 0, n - 1, 0);
    }
};