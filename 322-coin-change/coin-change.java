class Solution {

    int[] dp;
    int INF = Integer.MAX_VALUE / 2;
    private int solve(int[] coins,int amount)
    {
        if(amount == 0)
        return 0;

        if(dp[amount] != -1)
        return dp[amount];

        int minCoins = INF;
        for(int i = 0; i < coins.length; i++)
        {
            if(amount >= coins[i])
            minCoins = Math.min(minCoins,1 + solve(coins,amount-coins[i]));
        }

        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) 
    {
        dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        int ans = solve(coins,amount);
        return ans >= INF ? -1 : ans;
    }
}