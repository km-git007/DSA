class Solution {
    
    // Directions for moving up, down, left, and right
    private static int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private int n,m;
    private int bfs(int startRow, int startCol, int[][] grid) 
    { 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol}); 
        // marking the cell as vis
        grid[startRow][startCol] = -1;

        int perimeter = 0;       
        while (!q.isEmpty()) 
        {
            int[] currCell = q.poll();
            int currRow = currCell[0];
            int currCol = currCell[1];
                        
            // Explore neighbors
            for (int[] dir : directions) 
            {
                int row = currRow + dir[0];
                int col = currCol + dir[1];
                // Check if the new position is within bounds and not visited.
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) 
                {
                    q.add(new int[]{row,col});
                    grid[row][col] = -1;
                }
                else if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0)
                perimeter++;
            }
        }
        return perimeter;
    }

    public int islandPerimeter(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                return bfs(i,j,grid);
            }
        }
        // no isLand exists hence return -1.
        return -1;
    }
}