class Solution {
    private Integer[] dp;
    private int uniqueBSTs(int n) {
        if(n == 0){
            return 1;
        }
        
        if(dp[n] != null){
            return dp[n];
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count += uniqueBSTs(i - 1) * uniqueBSTs(n - i);
        }
        return dp[n] = count;
    }
    
    public int numTrees(int n) {
        dp = new Integer[n + 1];
        return uniqueBSTs(n);
    }
}