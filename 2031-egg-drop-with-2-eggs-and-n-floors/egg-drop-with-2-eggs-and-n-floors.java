class Solution {
    private int[][] dp;
    private int solve(int eggs, int floors)
    {
        if(eggs == 1 || floors == 0 || floors == 1)
        return floors;

        if(dp[eggs][floors] != -1)
        return dp[eggs][floors];

        int minMoves = Integer.MAX_VALUE;
        for(int k = 1; k <= floors; k++)
        {
            int eggBreaks = solve(eggs - 1, k - 1);
            int doesntBreak = solve(eggs, floors - k);
            int moves = 1 + Math.max(eggBreaks, doesntBreak);

            minMoves = Math.min(moves, minMoves);
        }
        return dp[eggs][floors] = minMoves;
    }

    public int twoEggDrop(int n) 
    {
        dp  = new int[3][n + 1];
        for(int i = 0; i < 3; i++)
        Arrays.fill(dp[i], -1);

        return solve(2, n);
    }
}