class Solution {
private:
    int maxLength;
    vector<vector<int>> adj;
    
    int solve(int node, string& s) {
        int longest = 0, secondLongest = 0;
        
        for(int adjNode : adj[node]) {
            int lengthOfChild = solve(adjNode, s);
            
            if(s[node] == s[adjNode]) {
                continue;
            }
            
            if(lengthOfChild > longest) {
                secondLongest = longest;
                longest = lengthOfChild;
            } else if(lengthOfChild > secondLongest) {
                secondLongest = lengthOfChild;
            }
        }
        
        maxLength = max(maxLength, 1 + longest + secondLongest);
        return 1 + longest;
    }
    
    void buildGraph(vector<int>& parent, string& s) {
        adj.resize(s.length());
        
        for(int i = 1; i < parent.size(); i++) {
            adj[parent[i]].push_back(i);
        }
    }

public:
    int longestPath(vector<int>& parent, string s) {
        maxLength = 0;
        buildGraph(parent, s);
        solve(0, s);
        return maxLength;
    }
};
