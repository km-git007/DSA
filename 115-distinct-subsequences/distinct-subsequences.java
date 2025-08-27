class Solution {
    private Integer[][] dp;
    private int solve(int n, int m, String s, String t) {
        if(m == 0) return 1;
        if(n == 0) return 0;
        
        if(dp[n][m] != null) return dp[n][m];
        
        if(s.charAt(n - 1) == t.charAt(m - 1)) {
            return dp[n][m] = solve(n - 1, m - 1, s, t) + solve(n - 1, m, s, t);
        }

        return dp[n][m] = solve(n - 1, m, s, t);
    }

    public int numDistinct(String s, String t){
        dp = new Integer[s.length() + 1][t.length() + 1];
        return solve(s.length(), t.length(), s, t);
    }
}