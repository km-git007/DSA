class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) 
    {
        vector<string> res;

        // to look for available ingredients.
        unordered_set<string> supply(supplies.begin(), supplies.end());

        // to look for ingredients needed in a particular recipe
        unordered_map<string, vector<string>> recipeIngredientMap;
        for(int i = 0; i < recipes.size(); i++)
        recipeIngredientMap[recipes[i]] = ingredients[i];

        // contains all the recipes yet to be made
        queue<string> q;
        for(string recipe : recipes)
        q.push(recipe);

        while(!q.empty())
        {
            int levelSize = q.size();
            bool noRecipeMade = true;
            while(levelSize--)
            {
                auto currR = q.front();
                q.pop();
                auto reqIngredients = recipeIngredientMap[currR];

                bool canMakeRecipe = true;
                for(string ingredient : reqIngredients)
                {
                    if(!supply.count(ingredient))
                    {
                        canMakeRecipe = false;
                        q.push(currR);
                        break;
                    }
                }

                if(canMakeRecipe)
                {
                    supply.insert(currR);
                    res.push_back(currR);
                    noRecipeMade = false;
                }
            }

            if(noRecipeMade)
            break;
        }

        return res;
    }
};