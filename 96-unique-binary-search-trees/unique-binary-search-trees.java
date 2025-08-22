class Solution {
    int[] dp;
    private int solve(int n){
        if(n == 0 || n == 1) return 1;

        if(dp[n] != -1) return dp[n];
        
        int uniqueBSTs = 0;
        for(int i = 1; i <= n; i++){
            uniqueBSTs += solve(i - 1) * solve(n - i);
        }
        return dp[n] = uniqueBSTs;
    }

    public int numTrees(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
}