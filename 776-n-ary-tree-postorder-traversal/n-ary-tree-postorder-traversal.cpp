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
  
    vector<int> postorder(Node* root) 
    {
        vector<int> ans;
        if(!root)
        return ans;
        
        stack<Node*> s;
        s.push(root);
        while(!s.empty())
        {
            Node* node= s.top();
            s.pop();
            vector<Node*> v=node->children;

            ans.push_back(node->val);

            for(Node* node : v)
            s.push(node);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};