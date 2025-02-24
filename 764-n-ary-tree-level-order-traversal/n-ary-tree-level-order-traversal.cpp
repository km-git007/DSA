/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) 
    {
        vector<vector<int>> ans;
        if (!root) return ans;

        queue<Node*> q;
        q.push(root);

        while (!q.empty()) 
        {
            int levelSize = q.size();
            vector<int> temp;
            for (int i = 0; i < levelSize; i++) 
            {
                Node* node = q.front();
                q.pop();
                
                temp.push_back(node->val);

                for(Node* child : node->children)
                q.push(child);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};