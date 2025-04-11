class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int INF = Integer.MAX_VALUE / 2;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        Arrays.sort(coins);
        for(int i = 1; i <= amount; i++)
        {
            for(int coin : coins)
            {
                if(i < coin)
                break;

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] >= INF ? -1 : dp[amount];
    }
}