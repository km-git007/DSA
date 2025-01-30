class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) 
    {
        int n = piles.size();
        Integer[][] dp = new Integer[n + 1][k + 1];

        for(int i = 0; i < n + 1; i++)
        {
            for(int j = 0; j < k + 1; j++)
            {
                if(i == 0 || j == 0)
                dp[i][j] = 0;

                else
                {
                    int notTake = dp[i - 1][j];
                    int take = 0, total = 0;
                    for(int index = 0; index < piles.get(i - 1).size() && index < j; index++)
                    {
                        total += piles.get(i - 1).get(index);
                        take = Math.max(take, total + dp[i - 1][j - (index + 1)]);
                    }
                    dp[i][j] = Math.max(take, notTake);
                }
            }
        }
        return dp[n][k];
    }
}