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
    vector<vector<int>> zigzagLevelOrder(TreeNode* node) 
    {
        vector<vector<int>> v;
        if(node == NULL)
        return v;

        queue<TreeNode*> q;
        q.push(node);
     
        bool flag=true;
        while(!q.empty())
        {
            int level =q.size();
            vector<int> temp(level);
            for(int i=0;i<level;i++)
            {
                TreeNode* curr=q.front();
                q.pop();
            
                if(flag)
                temp[i]=curr->val;
                else
                temp[level-i-1]=curr->val;
            
                if(curr->left!=NULL)
                q.push(curr->left);

                if(curr->right!=NULL)
                q.push(curr->right);
            }
            flag=!flag;
            v.push_back(temp);
        }
        return v;
    }
};