class Solution {
    public int longestPalindromeSubseq(String s) 
    {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single-character substrings are palindromes of length 1
        for(int i = 0; i < n; i++) 
        dp[i][i] = 1;

        // Build the dp table bottom-up
        for (int len = 2; len <= n; len++) {  // Length of the substring
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }

        // The result is stored in dp[0][n-1] (whole string)
        return dp[0][n - 1];
    }
}