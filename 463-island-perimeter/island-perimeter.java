class Solution {
    private int n, m, perimeter;
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void findPerimeter(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0){
            perimeter++;
            return;
        }

        if(grid[row][col] == -1){
            return;
        }

        // mark the cell as visited
        grid[row][col] = -1;

        for(int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            findPerimeter(nextRow, nextCol, grid);
        }
    }

    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        perimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    findPerimeter(i, j, grid);
                    return perimeter; // stop immediately
                }
            }
        }

        return -1;
    }
}