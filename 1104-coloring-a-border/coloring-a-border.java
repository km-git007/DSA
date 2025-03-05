class Solution {
    private int n,m;
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    private int check(int row, int col, int color, int[][] grid)
    {
        if(row >= n || row < 0 || col >= m || col < 0 || Math.abs(grid[row][col]) != color)
        return 0;

        return 1;
    }

    private void dfs(int row, int col, int originalColor, int[][] grid)
    {
        if(row >= n || row < 0 || col >= m || col < 0 || grid[row][col] != originalColor || grid[row][col] < 0)
        return;

        // mark the current cell as vis
        grid[row][col] = -grid[row][col];

        for(int[] dir : directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(r, c, originalColor, grid);
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) 
    {
        int originalCol = grid[row][col];
        if(originalCol == color)
        return grid;

        n = grid.length;
        m = grid[0].length;

        // flip all the cells of the connected component to teir negative 
        dfs(row, col, originalCol, grid);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] > 0)
                continue;

                int count = 0;
                for(int[] dir : directions)
                {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    count += check(r, c, Math.abs(grid[i][j]), grid);
                }
                if(count == 4)
                grid[i][j] = Math.abs(grid[i][j]);
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] < 0)
                grid[i][j] = color;
            }
        }

        return grid;
    }
}