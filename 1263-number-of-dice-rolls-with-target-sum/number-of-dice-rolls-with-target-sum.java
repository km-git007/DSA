class Solution {
    private final int MOD = 1_000_000_007;
    private int[][] dp;
    private int recur(int n, int k, int target){
        if(n == 0 && target == 0){
            return 1;
        }

        if(n < 0 || target < 0){
            return 0;
        }
        
        if(dp[n][target] != -1){
            return dp[n][target];
        }

        int ways = 0;
        for(int i = 1; i <= k; i++){
            ways = ways % MOD + recur(n - 1, k, target - i) % MOD;
        }
        return dp[n][target] = ways % MOD;
    }

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return recur(n, k, target);
    }
}