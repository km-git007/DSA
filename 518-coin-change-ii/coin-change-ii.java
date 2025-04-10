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

        int notTake = solve(coins, amount, index + 1);

        int take = 0;
        if(amount >= coins[index])
        take = solve(coins, amount - coins[index], index);

        return dp[amount][index] = take + notTake;
    }

    public int change(int amount, int[] coins) 
    {
        dp = new Integer[amount + 1][coins.length + 1];
        return solve(coins, amount, 0);
    }
}