class Solution {
    private int[][] dp;
    private int solve(int eggs, int floors)
    {
        if(eggs == 1 || floors == 0 || floors == 1)
        return floors;

        if(dp[eggs][floors] != -1)
        return dp[eggs][floors];

        int low = 1, high = floors, minMoves = Integer.MAX_VALUE;

        while (low <= high) 
        {
            int mid = low + (high - low) / 2;

            int eggBreaks = solve(eggs - 1, mid - 1);
            int doesNotBreak = solve(eggs, floors - mid);

            int moves = 1 + Math.max(eggBreaks, doesNotBreak);
            minMoves = Math.min(minMoves, moves);

            if(eggBreaks > doesNotBreak) 
            high = mid - 1;

            else 
            low = mid + 1;
        }

        return dp[eggs][floors] = minMoves;
    }
    
    public int superEggDrop(int k, int n) 
    {
        dp  = new int[k + 1][n + 1];
        for(int i = 0; i <= k; i++)
        Arrays.fill(dp[i], -1);

        return solve(k, n);
    }
}