class Solution {
    public boolean canPartition(int[] nums) 
    {
        int Sum = Arrays.stream(nums).sum();
        // return false if Sum not divisible by '2'
        if(Sum % 2 != 0)
        return false;

        int sum = Sum / 2;
        int n = nums.length;

        // create dp array
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // fill the first column
        for(int i = 0; i < n + 1; i++)
        dp[i][0] = true;

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j < sum + 1; j++)
            {
                if(j - nums[i - 1] >= 0)
                dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];

                else
                dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}