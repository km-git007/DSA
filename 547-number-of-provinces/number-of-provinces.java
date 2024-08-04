class Solution {
    private int n;
    private void solve(int row,boolean[] vis,int[][] isConnected)
    {
        for(int col=0;col<n;col++)
        {
            if(isConnected[row][col]==1 && !vis[col])
            {
                vis[col]=true;
                solve(col,vis,isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        n=isConnected.length;
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                vis[i]=true;
                solve(i,vis,isConnected);
                count++;
            }
        }
        return count;
    }
}