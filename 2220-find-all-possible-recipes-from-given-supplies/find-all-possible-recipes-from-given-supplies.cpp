class Solution {
public:

    unordered_map<string, int> inDegree;
    unordered_map<string, unordered_set<string>> buildGraph(vector<string>& recipes, vector<vector<string>>& ingredients) 
    {
        unordered_map<string, unordered_set<string>> adj;  // Adjacency list
        for (int i = 0; i < recipes.size(); i++) 
        {
            string recipe = recipes[i];
            // Number of ingredients needed
            inDegree[recipe] = ingredients[i].size();  

            // Edge: ingredient -> recipe
            for(const string& ingredient : ingredients[i])
            adj[ingredient].insert(recipe);  
        }

        return adj;  // Return the graph
    }

    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) 
    {
        vector<string> res;

        // any of the supply item doesnt need any other item to be made. It can exist independently.
        for(string supply : supplies)
        inDegree[supply] = 0;

        // build adj List
        auto adj = buildGraph(recipes, ingredients);

        // contains all the recipes yet to be made
        queue<string> q;
        for(auto [item, ind] : inDegree)
        {
            if(ind == 0)
            q.push(item);
        }

        while(!q.empty())
        {
            auto item = q.front();
            q.pop();

            for(auto adjItem : adj[item])
            {
                inDegree[adjItem]--;
                if(inDegree[adjItem] == 0)
                {
                    q.push(adjItem);
                    res.push_back(adjItem);
                }
            }
        }
        return res;
    }
};