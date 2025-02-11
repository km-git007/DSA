class Solution {
    private static int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    int n, m, perimeter;
    private int dfs(int row, int col, int[][] grid) 
    { 
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0)
        return 1;

        // already visited cell
        if(grid[row][col] == -1)
        return 0;

        // mark as vis
        grid[row][col] = -1;

        int cellPeri = 0;
        for(var dir : directions)
        {
            int x = row + dir[0];
            int y = col + dir[1];
            cellPeri += dfs(x, y, grid);
        }

        perimeter += cellPeri;
        return 0;
    }

    public int islandPerimeter(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        perimeter = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                dfs(i,j,grid);
            }
        }

        return perimeter;
    }
}