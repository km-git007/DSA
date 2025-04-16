class Solution {
    private int[][] dp;
    private int LCS(int n, int m, String s, String t)
    {
        if(n == 0 || m == 0)
        return 0;

        if(dp[n][m] != -1)
        return dp[n][m];

        if(s.charAt(n - 1) == t.charAt(m - 1))
        return 1 + LCS(n - 1, m - 1, s, t);

        return dp[n][m] = Math.max(LCS(n - 1, m, s, t), LCS(n, m - 1, s, t));
    }

    public int minDistance(String word1, String word2) 
    {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++)
        Arrays.fill(dp[i], -1);

        int lcs = LCS(word1.length(), word2.length(), word1, word2);
        return word1.length() + word2.length() - 2 * lcs;
    }
}