class Solution {
    private int n;
    private boolean[][] vis;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean dfs(int row, int col, int time, int[][] grid)
    {
        if(row < 0 || col < 0 || row >= n || col >= n || vis[row][col] || grid[row][col] > time)
        return false;

        if(row == n - 1 && col == n - 1)
        return true;
        
        // mark the cell as visited
        vis[row][col] = true;

        for(var dir : directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            if(dfs(r, c, time, grid))
            return true;
        }

        return false;
    }

    public int swimInWater(int[][] grid) 
    {
        n = grid.length;
        
        int end = n * n - 1;
        int start = 0;
        int minTime = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            vis = new boolean[n][n];
            if(dfs(0, 0, mid, grid))
            {
                minTime = mid;
                end = mid - 1;
            }
            else
            start = mid+1;
        }  
        return minTime; 
    }
}