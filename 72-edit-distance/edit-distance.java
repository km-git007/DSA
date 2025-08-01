class Solution {
        int n, m;
    int[][] dp;
    private int solve(int i, int j, String word1, String word2){
        // add the remaining
        if(i >= n) return m - j;
        // delete the remaining
        if(j >= m) return n - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            return solve(i+1, j+1, word1, word2);
        }
        int insert = solve(i, j + 1, word1, word2);
        int replace = solve(i + 1, j + 1, word1, word2);
        int delete = solve(i + 1, j, word1, word2);

        return dp[i][j] = 1 + Math.min(insert, Math.min(replace, delete));
    }

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, word1, word2);
    }
}