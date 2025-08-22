class Solution {
private int maxLength;
    private List<Integer>[] adj;
    private int solve(int node, String s){
        int longest = 0, secondLongest = 0;
        for(int adjNode : adj[node]){
            
            int lengthOfChild = solve(adjNode, s);
            
            if(s.charAt(node) == s.charAt(adjNode)){
                continue;
            }
            
            if(lengthOfChild > longest){
                secondLongest = longest;
                longest = lengthOfChild;
            }else if(lengthOfChild > secondLongest){
                secondLongest = lengthOfChild;
            }
        }
        
        maxLength = Math.max(maxLength, 1 + longest + secondLongest);
        return 1 + longest;
    }
    
    private void buildGraph(int[] parent, String s){
        adj = new ArrayList[s.length()];
        for(int i = 0; i < parent.length; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 1; i < parent.length; i++){
            adj[parent[i]].add(i);
        }
    }

    public int longestPath(int[] parent, String s) {
        maxLength = 0;
        buildGraph(parent, s);
        solve(0, s);
        return maxLength;
    }
}