class Solution {
    private Integer[][] dp;
    private int solve(int i, int j, String word1, String word2){
        if(i == word1.length() && j == word2.length()){
            return 0;
        }

        // Need to insert remaining chars from word2
        if(i == word1.length()){
            return word2.length() - j;  
        }

        // Need to delete remaining chars from word1
        if(j == word2.length()){
            return word1.length() - i; 
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(i + 1, j + 1, word1, word2);
        }

        int insert = solve(i, j + 1, word1, word2);
        int replace = solve(i + 1, j + 1, word1, word2);
        int delete = solve(i + 1, j, word1, word2);
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        if(word2.length() > word1.length()){
            return minDistance(word2, word1);
        }

        dp = new Integer[word1.length() + 1][word2.length() + 1];
        return solve(0, 0, word1, word2);
    }
}