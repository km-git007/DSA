class Solution {
    private int vis[];
    int n;
    private void bfs(int node,int[][] isConnected)
    {
        vis[node]=1;
        // marking the current node.
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty())
        {
            int currNode=q.poll();
            for(int i=0;i<n;i++)
            {
                if(isConnected[currNode][i]==1 && vis[i]==0)
                {
                    q.offer(i);
                    vis[i]=1;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        n=isConnected.length;
        vis=new int[n];

        int provinces=0;
        // No need to create the adjacency matrix.
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                bfs(i,isConnected);
                provinces++;
            }
        }
        return provinces;
    }
}