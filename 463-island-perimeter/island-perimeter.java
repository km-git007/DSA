class Solution {
    
    // Directions for moving up, down, left, and right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    int n,m;
    int[][] vis;
    private int bfs(int startRow, int startCol,int[][] grid) 
    { 
        vis[startRow][startCol]=1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol}); 

        int perimeter=0;       
        while (!q.isEmpty()) 
        {
            int[] currCell=q.poll();
            int currRow=currCell[0];
            int currCol=currCell[1];
                        
            // Explore neighbors
            for (int i=0;i<4;i++) 
            {
                int row=currRow+rowDir[i];
                int col=currCol+colDir[i];
                // Check if the new position is within bounds and not visited.
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0 && grid[row][col]==1) 
                {
                    q.add(new int[]{row,col});
                    vis[row][col]=1;
                }
                else if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0)
                perimeter++;
            }
        }
        return perimeter;
    }

    public int islandPerimeter(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        vis=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                return bfs(i,j,grid);
            }
            
        }
        return -1;
    }
}