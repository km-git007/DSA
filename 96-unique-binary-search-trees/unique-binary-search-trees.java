class Solution {
    private Integer[] dp;
    private int solve(int n){
        if(n == 0) return 1;

        if(dp[n] != null) return dp[n];

        int count = 0;
        for(int i = 1; i <= n; i++){
            count += (solve(i - 1) * solve(n - i));
        }
        return dp[n] = count;
    }
    public int numTrees(int n) {
        dp = new Integer[n + 1];
        return solve(n);
    }
}