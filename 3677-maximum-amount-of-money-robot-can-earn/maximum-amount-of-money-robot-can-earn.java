class Solution {
    private int n, m;
    private Integer[][][] dp;
    private int solve(int row, int col, int moves, int[][] coins) {
        // Out of bounds condition
        if (row >= n || col >= m) 
            return Integer.MIN_VALUE;

        // Base case: reached the bottom-right corner
        if (row == n - 1 && col == m - 1) {
            if (coins[row][col] >= 0 || moves == 0)
                return coins[row][col];
            return 0; // Neutralize the thief if moves are available
        }

        // Check if already calculated
        if (dp[row][col][moves] != null)
            return dp[row][col][moves];

        // If the current cell is not a thief
        if (coins[row][col] >= 0) {
            return dp[row][col][moves] = coins[row][col] + 
                Math.max(solve(row + 1, col, moves, coins), solve(row, col + 1, moves, coins));
        }

        // If the current cell is a thief
        int neutralizeThief = Integer.MIN_VALUE;
        if (moves > 0) { // Only neutralize if moves > 0
            neutralizeThief = Math.max(
                solve(row + 1, col, moves - 1, coins),
                solve(row, col + 1, moves - 1, coins)
            );
        }

        int notNeutralizeThief = coins[row][col] + 
            Math.max(solve(row + 1, col, moves, coins), solve(row, col + 1, moves, coins));

        // Return the maximum profit
        return dp[row][col][moves] = Math.max(neutralizeThief, notNeutralizeThief);
    }

    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;

        dp = new Integer[n][m][3];

        // Start the recursion from (0, 0) with 2 moves available
        return solve(0, 0, 2, coins);
    }
}
