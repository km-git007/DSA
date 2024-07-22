class Solution {

    // Directions for moving up, down, left, and right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    int n,m;
    private int bfs(Queue<int[]> q,int[][] grid) 
    { 
        int dist=-1;
        while (!q.isEmpty()) 
        {
            int levelSize=q.size();
            dist++;
            for(int j=0;j<levelSize;j++)
            {
                int[] currCell=q.poll();
                int currRow=currCell[0];
                int currCol=currCell[1];
                for (int i=0;i<4;i++) 
                {
                    int row=currRow+rowDir[i];
                    int col=currCol+colDir[i];
                    // Check if the new position is within bounds and not visited.
                    if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==0) 
                    {
                        q.add(new int[]{row,col});
                        grid[row][col]=1;
                    }
                }
            }
        }
        return dist;
    }

    public int maxDistance(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                q.add(new int[]{i,j}); 
            }
        }

        if(q.size()==0 || q.size()==n*m)
        return -1;
        return bfs(q,grid);
    }
}