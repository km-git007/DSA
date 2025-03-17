class Solution {
    private int n, m;
    private boolean dfs(int row, int col, int[][] grid)
    {
        if(row >= n || col >= m || grid[row][col] == 0)
        return false;

        if(row == n - 1 && col == m - 1)
        return true;

        // Mark the current cell as visited
        grid[row][col] = 0;

        return dfs(row, col + 1, grid) || dfs(row + 1, col, grid);
    }

    public boolean isPossibleToCutPath(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;

        // If there's no path from (0,0) to (n-1,m-1), no need to flip anything
        if(!dfs(0, 0, grid))
        return true;

        // Restore the (0,0) cell to 1
        grid[0][0] = 1;

        // If another path still exists, we cannot disconnect the path
        if(dfs(0, 0, grid))
        return false;

        return true;
    }
}
