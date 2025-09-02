
class Solution {
    private int[][] dp;
    private int countDistinctSubsequences(int n, int m, String s, String t){
        if(m == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        int count = 0;
        // if the (m - 1)th char doesn't match (n - 1)th char
        count += countDistinctSubsequences(n - 1, m, s, t);

        // if chars match
        if(s.charAt(n - 1) == t.charAt(m - 1)){
            count += countDistinctSubsequences(n - 1, m - 1, s, t);
        }

        return dp[n][m] = count;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= t.length(); j++){
                if(j == 0){
                    dp[i][j] = 1;
                }
                else if(i == 0){
                    dp[i][j] = 0;
                }
                else{
                    int count = 0;
                    count += dp[i - 1][j];
                    if(s.charAt(i - 1) == t.charAt(j - 1)){
                        count += dp[i - 1][j - 1];
                    }
                    dp[i][j] = count;
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}