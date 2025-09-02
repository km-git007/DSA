class Solution {
    private int[][] dp;
    private int solve(int start, int end, String s){
        if(start > end){
            return 0;
        }

        if(start == end){
            return 1;
        }
        
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        if(s.charAt(start) == s.charAt(end)){
            return dp[start][end] = 2 + solve(start + 1, end - 1, s);
        }

        return dp[start][end] = Math.max(solve(start + 1, end, s), solve(start, end - 1, s));
    }
    
    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, s.length() - 1, s);
    }
}