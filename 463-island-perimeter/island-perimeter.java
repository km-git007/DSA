class Solution {
    
    // Directions for moving up, down, left, and right
    private static int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private int n,m;
    private boolean check(int row, int col, int[][] grid) 
    { 
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1;
    }

    public int islandPerimeter(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int cellPeri = 0;
                if(grid[i][j] == 1)
                {
                    // Explore neighbors
                    for (int[] dir : directions) 
                    {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        cellPeri += (check(row, col, grid) ? 0 : 1);
                    }
                    // add cell perimeter to total perimeter
                    perimeter += cellPeri;
                }
            }
        }
        // return perimeter
        return perimeter ;
    }
}