class Solution {    
    public int numTrees(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        
        for(int n = 1; n <= N; n++) {
            for(int root = 1; root <= n; root++) {
                dp[n] += dp[root - 1] * dp[n - root];
            }
        }
        return dp[N];
    }
}