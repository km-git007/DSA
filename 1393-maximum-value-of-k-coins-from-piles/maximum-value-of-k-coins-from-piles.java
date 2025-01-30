class Solution {
    private Integer[][] dp;
    private int solve(int index, int coins, List<List<Integer>> piles)
    {
        if(index == piles.size())
        return 0;

        if(dp[index][coins] != null)
        return dp[index][coins];

        // no coins taken from the current pile
        int notTake = solve(index + 1, coins, piles);

        int take = 0, total = 0;
        // coins taken from the current pile
        for(int i = 0; i < piles.get(index).size() && i < coins; i++)
        {
            total += piles.get(index).get(i);
            take = Math.max(take, total + solve(index + 1, coins - (i + 1), piles));
        }

        return dp[index][coins] = Math.max(take, notTake);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) 
    {
        int n = piles.size();
        dp = new Integer[n + 1][k + 1];

        return solve(0, k, piles);
    }
}