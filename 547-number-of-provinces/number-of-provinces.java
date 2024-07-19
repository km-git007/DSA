class Solution {
    private int vis[];
    int n;
    private void dfs(int node,int[][] isConnected)
    {
        vis[node]=1;
        // marking the current node.

        for(int i=0;i<n;i++)
        {
            if(isConnected[node][i]==1 && vis[i]==0)
            dfs(i,isConnected);
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        n=isConnected.length;
        vis=new int[n];

        int provinces=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,isConnected);
                provinces++;
            }
        }
        return provinces;
    }
}