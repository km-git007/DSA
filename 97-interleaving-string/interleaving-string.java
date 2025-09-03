class Solution {
    private Boolean[][] dp;
    private boolean solve(int n, int m, String s1, String s2, String s3){
        if(n == 0 && m == 0){
            return true;
        }

        if(n == 0){
            return s2.substring(0, m).equals(s3.substring(0, m));
        }

        if(m == 0){
            return s1.substring(0, n).equals(s3.substring(0, n));
        }

        if(dp[n][m] != null){
            return dp[n][m];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1) && s1.charAt(n - 1) == s3.charAt(m + n - 1)){
            return dp[n][m] = solve(n - 1, m, s1, s2, s3) || solve(n, m - 1, s1, s2, s3);
        }

        if(s1.charAt(n - 1) == s3.charAt(m + n - 1)){
            return dp[n][m] = solve(n - 1, m, s1, s2, s3);
        }

        if(s2.charAt(m - 1) == s3.charAt(m + n - 1)){
            return dp[n][m] = solve(n, m - 1, s1, s2, s3);
        }

        return dp[n][m] = false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
        return false;

        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solve(s1.length(), s2.length(), s1, s2, s3);
    }
}