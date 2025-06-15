class Solution {
public:
    void buildGraph(vector<string>& recipes, vector<vector<string>>& ingredients, 
    unordered_map<string, int> &ind, unordered_map<string, vector<string>> &adj)
    {
        for(int i = 0; i < recipes.size(); i++)
        {
            string recipe = recipes[i];
            for(string ingredient : ingredients[i])
            {
                if(!adj.count(ingredient))
                adj[ingredient] = vector<string>();

                adj[ingredient].push_back(recipe);
                ind[recipe]++;
            }
        }
    }

    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) 
    {
        unordered_map<string, vector<string>> adj;
        unordered_map<string, int> ind;
        buildGraph(recipes, ingredients, ind, adj);

        queue<string> q;
        for(string supply : supplies)
        q.push(supply);

        vector<string> res;
        while(!q.empty())
        {
            string node = q.front();
            q.pop();

            if(!adj.count(node))
            continue;

            for(string adjNode : adj[node])
            {
                ind[adjNode]--;
                if(ind[adjNode] == 0)
                {
                    q.push(adjNode);
                    res.push_back(adjNode);
                }
            }
        }
        return res;
    }
};