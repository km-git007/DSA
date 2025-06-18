class Solution {
    public int countSquares(int[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(matrix[i][j] == 0)
                continue;

                if(i == 0 || j == 0)
                dp[i][j] = 1;

                else
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;

                count += dp[i][j];
            }
        }
        return count;
    }
}