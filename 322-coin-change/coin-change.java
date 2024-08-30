class Solution {

    int[] dp=new int[10001];
    private int solve(int[] coins,int amount)
    {
        if(amount==0)
        return 0;

        if(dp[amount]!=-1)
        return dp[amount];

        int minCoins=Integer.MAX_VALUE-1;
        for(int i=0;i<coins.length;i++)
        {
            if(amount>=coins[i])
            minCoins=Math.min(minCoins,1+solve(coins,amount-coins[i]));
        }
        return dp[amount]=minCoins;
    }

    public int coinChange(int[] coins, int amount) 
    {
        Arrays.fill(dp,-1);
        int ans=solve(coins,amount);

        if(ans>=Integer.MAX_VALUE-1)
        return -1;
        return ans;
    }
}