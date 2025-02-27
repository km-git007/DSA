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
    int index;
    TreeNode* buildBST(vector<int>& preorder, int upperBound) 
    {
        if(index == preorder.size() || preorder[index] > upperBound)
        return nullptr;

        TreeNode* node = new TreeNode(preorder[index++]);
        
        node->left = buildBST(preorder, node->val);
        node->right = buildBST(preorder, upperBound);
        
        return node;
    }
    
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) 
    {
        index = 0;
        return buildBST(preorder, INT_MAX);
    }
};