class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> pathList = new ArrayList<>();
    private void findPaths(int node, int target,int[][] graph)
    {
        path.add(node);

        if(node == target)
        pathList.add(new ArrayList<>(path));        
        
        for(int adjNode : graph[node])
        findPaths(adjNode, target, graph);
        
        path.removeLast();
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        int target = graph.length -1;
        findPaths(0, target, graph);
        return pathList;
    }
}