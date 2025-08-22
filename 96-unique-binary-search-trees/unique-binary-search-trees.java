class Solution {
    // int[] dp;
    // private int solve(int n){
    //     if(n == 0 || n == 1) return 1;

    //     if(dp[n] != -1) return dp[n];
        
    //     int uniqueBSTs = 0;
    //     for(int i = 1; i <= n; i++){
    //         uniqueBSTs += solve(i - 1) * solve(n - i);
    //     }
    //     return dp[n] = uniqueBSTs;
    // }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int node = 1; node <= n; node++){
            for(int root = 1; root <= node; root++){
                dp[node] += dp[root - 1] * dp[node - root];
            }
        }
        return dp[n];
    }
}