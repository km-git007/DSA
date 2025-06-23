class Solution {
public:
    bool check(int node, int col, vector<vector<int>>& graph, vector<int> &color)
    {
        if(color[node] != -1)
        return col == color[node];

        color[node] = col;
        for(int nbr : graph[node])
        {
            if(!check(nbr, -col, graph, color))
            return false;
        }

        return true;
    }

    bool isBipartite(vector<vector<int>>& graph) 
    {
        int n = graph.size();
        vector<int> color(n, -1); 

        for(int node = 0; node < n; node++)
        {
            if(color[node] == -1 && !check(node, 2, graph, color))
            return false;
        }
        
        return true;
    }
};