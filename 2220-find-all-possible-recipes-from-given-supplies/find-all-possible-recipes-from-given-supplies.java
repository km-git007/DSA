class Solution {
    private Map<String, Integer> ind;
    private Map<String, List<String>> buildGraph(String[] recipes, List<List<String>> ingredients)
    {
        Map<String, List<String>> adj = new HashMap<>();
        for(int i = 0; i < recipes.length; i++)
        {
            String recipe = recipes[i];
            for(String ingredient : ingredients.get(i))
            {
                // put the ingredient as one of the dependency of the recipe
                adj.putIfAbsent(ingredient, new ArrayList<>());
                adj.get(ingredient).add(recipe);

                // increase the ind of recipe by 1
                ind.put(recipe, ind.getOrDefault(recipe, 0) + 1);
            }
        }
        return adj;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) 
    {
        // indegree Map
        ind = new HashMap<>();

        // build adjList
        var adj = buildGraph(recipes, ingredients);

        // supply have no dependency on anything
        Queue<String> q = new LinkedList<>();
        for(String supply : supplies)
        q.add(supply);


        List<String> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            String item = q.poll();

            // adj only contains keys for ingredients that are used in some recipe. But BFS queue q
            // includes every supply, and some supplies might not be used as ingredients in any recipe.
            if(!adj.containsKey(item)) 
            continue;

            for(String adjItem : adj.get(item))
            {
                ind.put(adjItem, ind.get(adjItem) - 1);
                if(ind.get(adjItem) == 0)
                {
                    res.add(adjItem);
                    q.add(adjItem);
                }
            }
        }
        return res;
    }
}