class Solution {
    private Boolean[] dp;
    private boolean hasZero(int num){
        int n = num;
        while(n > 0){
            if(dp[n] != null){
                return dp[n];
            }

            if(n % 10 == 0){
                return dp[num] = true;
            }
            n /= 10;
        }
        return dp[num] = false;
    }

    public int[] getNoZeroIntegers(int n) {
        dp = new Boolean[n + 1];
        for(int i = 1; i <= n; i++){
            if(!hasZero(i) && !hasZero(n - i)){
                return new int[]{i, n - i};
            }
        }
        return new int[0];
    }
}