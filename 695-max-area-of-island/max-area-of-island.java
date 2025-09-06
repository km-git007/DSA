class Solution {
    int n, m;
    public int maxAreaOfIsland(int[][] grid)
    {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea, dfs(i, j, grid, visited));
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int row, int col, int[][] grid, boolean[][] visited){
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }
        
        visited[row][col] = true;
        int count = 1;
        count += dfs(row + 1, col, grid, visited);
        count += dfs(row - 1, col, grid, visited);
        count += dfs(row, col + 1, grid, visited);
        count += dfs(row, col - 1, grid, visited);
        
        return count;
    }
}