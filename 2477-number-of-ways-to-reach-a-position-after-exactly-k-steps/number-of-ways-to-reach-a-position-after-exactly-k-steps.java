class Solution {
    private final int mod = 1000000007;
    private int start, target;
    private Integer[][] dp;
    private int solve(int pos, int k)
    {
        if(k == 0)
        return pos == target ? 1 : 0;

        if(dp[pos][k] != null)
        return dp[pos][k];

        int ahead = solve(pos + 1, k - 1) % mod;
        int back = solve(pos - 1, k - 1) % mod;

        return dp[pos][k] = (ahead + back) % mod;
    }

    public int numberOfWays(int startPos, int endPos, int k) 
    {
        start = k + startPos;
        target = k + endPos;

        dp = new Integer[3001][3001];
        return solve(start, k);
    }
}