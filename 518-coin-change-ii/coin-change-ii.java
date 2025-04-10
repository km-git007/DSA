class Solution {

    Integer[][] dp;
    private int solve(int[] coins, int amount, int index)
    {
        if(amount == 0)
        return 1;

        if(index >= coins.length)
        return 0;

        if(dp[amount][index] != null)
        return dp[amount][index];

        int ways = 0;
        for(int i = index; i < coins.length; i++)
        {
            if(amount < coins[i])
            break;

            ways += solve(coins, amount - coins[i], i);
        }

        return dp[amount][index] = ways;
    }

    public int change(int amount, int[] coins) 
    {
        dp = new Integer[amount + 1][coins.length + 1];
        Arrays.sort(coins);
        return solve(coins, amount, 0);
    }
}