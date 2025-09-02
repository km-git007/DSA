class Solution {
    private List<List<String>> res;
    private List<String> list;
    private boolean[][] dp;
    private void precompute(String s){
        int n = s.length();
        // Precompute palindromes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) dp[i][j] = true; // length 1 or 2
                    else dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
    }
    
    private void generatePalindromePartition(int start, String str) {
        if(start == str.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < str.length(); i++) {
            if(dp[start][i]){
                list.add(str.substring(start, i + 1));
                generatePalindromePartition(i + 1, str);
                list.removeLast();
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dp = new boolean[s.length()][s.length()];
        precompute(s);
        generatePalindromePartition(0, s);
        return res;
    }
}