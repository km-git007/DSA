class Solution {

    private int n, m;
    private boolean canReachBottomRightCell(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return false;
        }

        if(row == n - 1 && col == m - 1)
            return true;

        // Mark the current cell as visited
        grid[row][col] = 0;

        return canReachBottomRightCell(row, col + 1, grid) || canReachBottomRightCell(row + 1, col, grid);
    }

    public boolean isPossibleToCutPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        // matrix is disconnected if there exists no path already
        if(!canReachBottomRightCell(0, 0, grid)){
            return true;
        }

        // Restore the (0,0) cell to 1
        grid[0][0] = 1;

        // if you reach the bottom right cell
        return !canReachBottomRightCell(0, 0, grid);
    }
}