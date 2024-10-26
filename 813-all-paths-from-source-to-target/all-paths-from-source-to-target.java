class Solution {
    private int target;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> pathList = new ArrayList<>();
    private void findPaths(int node, int[] vis,int[][] graph)
    {
        path.add(node);
        
        if(node == target){
            pathList.add(new ArrayList<>(path));
        }
        
        vis[node] = 1;
        
        for(int adjNode : graph[node]){
            if(vis[adjNode] == 0){
                findPaths(adjNode, vis, graph);
            }
        }
        
        vis[node] = 0;
        
        path.removeLast();
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        target = graph.length -1;
        int[] vis = new int[graph.length];
        findPaths(0, vis, graph);
        return pathList;
    }
}