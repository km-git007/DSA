class Solution {
    private int low, high, zero, one;
    private int[] dp;
    private int mod = (int) (1e9 + 7);
    private int solve(int length)
    {
        if(length > high)
        return 0;

        if(length == high)
        return 1;

        if(dp[length] != -1)
        return dp[length];

        int res = (solve(length + zero) % mod + solve(length + one) % mod) % mod;

        if(length >= low)
        return dp[length] = 1 + res;

        return dp[length] = res;
    }
    public int countGoodStrings(int low, int high, int zero, int one) 
    {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;

        dp = new int[high];
        Arrays.fill(dp, -1);

        return solve(0);
    }
}