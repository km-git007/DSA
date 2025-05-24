/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) 
    {
        if(node == NULL)
        return NULL;

        unordered_map<Node*, Node*> map;
        map[node] = new Node(node->val);

        queue<Node*> q;
        q.push(node);
        while(!q.empty())
        {
            Node* currNode = q.front();
            q.pop();

            for(Node* nbr : currNode->neighbors)
            {
                // clone the neighbor only if its not cloned
                if(!map.count(nbr))
                {
                    map[nbr] = new Node(nbr->val);
                    q.push(nbr);
                }

                // Add the cloned neighbor to the current node's neighbors
                map[currNode]->neighbors.push_back(map[nbr]);
            }
        }
        return map[node];
    }
};