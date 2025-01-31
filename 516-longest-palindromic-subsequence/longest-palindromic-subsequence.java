class Solution {
    private Integer[][] dp;
    private int solve(int start, int end, String s)
    {
        if(start > end)
        return 0;

        if(start == end)
        return 1;

        if(dp[start][end] != null)
        return dp[start][end];

        if(s.charAt(start) == s.charAt(end))
        return dp[start][end] = 2 + solve(start + 1, end - 1, s);

        int skipStart = solve(start + 1, end, s);
        int skipEnd = solve(start, end - 1, s);

        return dp[start][end] = Math.max(skipStart, skipEnd);
    }

    public int longestPalindromeSubseq(String s) 
    {
        dp = new Integer[s.length()][s.length()];
        return solve(0, s.length() - 1, s);
    }
}