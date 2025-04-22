class Solution {
    private Map<String, Integer> inDegree;

    private Map<String, Set<String>> buildGraph(String[] recipes, List<List<String>> ingredients) {
        Map<String, Set<String>> adj = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {
                adj.computeIfAbsent(ingredient, k -> new HashSet<>()).add(recipe);
            }
        }
        return adj;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        inDegree = new HashMap<>();
        List<String> res = new ArrayList<>();

        // Supplies have in-degree 0
        for (String supply : supplies) {
            inDegree.put(supply, 0);
        }

        // Build the graph
        Map<String, Set<String>> adj = buildGraph(recipes, ingredients);

        // Queue for topological sort
        Queue<String> q = new LinkedList<>();
        for (String item : inDegree.keySet()) {
            if (inDegree.get(item) == 0) {
                q.offer(item);
            }
        }

        while (!q.isEmpty()) {
            String item = q.poll();
            if (!adj.containsKey(item)) continue;

            for (String next : adj.get(item)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    res.add(next);
                    q.offer(next);
                }
            }
        }

        return res;
    }
}
