class Solution {
    private int[][] dp;
    private int solve(int n, int m, String s, String t){
        if(n == 0 || m == 0){
            return 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s.charAt(n - 1) == t.charAt(m - 1)){
            return 1 + solve(n - 1, m - 1, s, t);
        }

        return dp[n][m] = Math.max(solve(n - 1, m, s, t), solve(n, m - 1, s, t));
    }

    public int longestCommonSubsequence(String s, String t)
    {
        dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(s.length(), t.length(), s, t);
    }
}