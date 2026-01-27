class Solution {
    private int[] dp;
    private int solve(int index, int[] cost){
        if(index >= cost.length) return 0;
        if(dp[index] != -1) return dp[index];
        return dp[index] = cost[index] + Math.min(solve(index + 1, cost), solve(index + 2, cost));
    }
    
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost), solve(1, cost));
    }
}