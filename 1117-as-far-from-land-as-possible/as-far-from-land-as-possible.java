class Solution {

    // Directions for moving up, down, left, and right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    int n,m;
    private int bfs(Queue<int[]> q,int[][] grid) 
    { 
        int dist=0,maxDist=0; 
        boolean flag=false;
        while (!q.isEmpty()) 
        {
            int levelSize=q.size();
            for(int j=0;j<levelSize;j++)
            {
                int[] currCell=q.poll();
                int currRow=currCell[0];
                int currCol=currCell[1];
                maxDist=currCell[2]; 
                for (int i=0;i<4;i++) 
                {
                    int row=currRow+rowDir[i];
                    int col=currCol+colDir[i];
                    // Check if the new position is within bounds and not visited.
                    if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==0) 
                    {
                        q.add(new int[]{row,col,dist+1});
                        grid[row][col]=1;
                        flag=true;
                    }
                }
            }
            dist++;
        }
        return (flag)?maxDist:-1;
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
                q.add(new int[]{i,j,0}); 
            }
        }
        return bfs(q,grid);
    }
}