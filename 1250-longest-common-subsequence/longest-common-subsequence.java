class Solution {
    private Integer[][] dp;
    private int LCS(int i, int j, String s, String t)
    {
        if(i == 0 || j == 0)
        return 0;

        if(dp[i][j] != null)
        return dp[i][j];

        if(s.charAt(i - 1) == t.charAt(j - 1))
        return dp[i][j] = 1 + LCS(i - 1, j - 1, s, t);

        return dp[i][j] = Math.max(LCS(i, j - 1, s, t), LCS(i - 1, j, s, t));
    }

    public int longestCommonSubsequence(String s, String t) 
    {
        dp = new Integer[s.length() + 1][t.length() + 1];
        return LCS(s.length(), t.length(), s, t);
    }
}