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

class Node {
public:
    int sum, mini, maxi;
    Node(int sum, int mini, int maxi) : sum(sum), mini(mini), maxi(maxi) {}
};

class Solution {
private: 
    int INF, maxSum;
    Node solve(TreeNode* root) 
    {
        if (!root) 
        return Node(0, INF, -INF);
        
        Node left = solve(root->left);
        Node right = solve(root->right);
        
        if(left.maxi < root->val && root->val < right.mini) 
        {
            int sum = left.sum + right.sum + root->val;
            maxSum = max(maxSum, sum);
            return Node(sum, min(left.mini, root->val), max(right.maxi, root->val));
        }
        
        return Node(max(left.sum, right.sum), -INF, INF);
    }
public:
    int maxSumBST(TreeNode* root) 
    {
        INF = INT_MAX/ 2;
        maxSum = -INF;
        solve(root);
        return maxSum < 0 ? 0 : maxSum;
    }
};