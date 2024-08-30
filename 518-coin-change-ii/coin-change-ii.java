class Solution {

    int[][] dp=new int[5002][300];
    private int solve(int[] coins,int amount,int index)
    {
        if(amount==0)
        return 1;

        if(dp[amount][index]!=-1)
        return dp[amount][index];

        int ways=0;
        for(int i=index;i<coins.length;i++)
        {
            if(amount>=coins[i])
            ways+=solve(coins,amount-coins[i],i);
        }
        return dp[amount][index]=ways;
    }

    public int change(int amount, int[] coins) 
    {
        for(int i=0;i<5002;i++)
        Arrays.fill(dp[i],-1);

        return solve(coins,amount,0);
    }
}