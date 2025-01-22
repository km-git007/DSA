class Solution {
    private int n,m;
    int[][] isBorder;
    // Directions array for up, down, left, right
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    private boolean check(int row, int col, int originalColor, int[][] grid)
    {
        if(row >= n || row < 0 || col >= m || col < 0 || grid[row][col] != originalColor)
        return false;

        return true;
    }

    private void dfs(int row, int col, int originalColor, int[][] grid)
    {
        if(row >= n || row < 0 || col >= m || col < 0 || grid[row][col] != originalColor || isBorder[row][col] == -1)
        return;

        // mark the current cell as vis
        isBorder[row][col] = -1;

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
        isBorder= new int[n][m];

        dfs(row, col, originalCol, grid);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(isBorder[i][j] != -1)
                continue;

                for(int[] dir : directions)
                {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if(!check(r, c, originalCol, grid))
                    {
                        isBorder[i][j] = 1;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(isBorder[i][j] == 1)
                grid[i][j] = color;
            }
        }

        return grid;
    }
}