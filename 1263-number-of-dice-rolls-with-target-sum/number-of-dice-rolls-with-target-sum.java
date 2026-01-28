class Solution {
    private final long MOD = 1_000_000_007;
    private long[][] dp;
    private long recur(int n, int k, int target){
        if(n == 0 && target == 0){
            return 1;
        }

        if(n < 0 || target < 0){
            return 0;
        }
        
        if(dp[n][target] != -1){
            return dp[n][target];
        }

        long ways = 0;
        for(int i = 1; i <= k; i++){
            ways += recur(n - 1, k, target - i) % MOD;
        }
        return dp[n][target] = ways % MOD;
    }

    public int numRollsToTarget(int n, int k, int target) {
        dp = new long[n + 1][target + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return (int)recur(n, k, target);
    }
}