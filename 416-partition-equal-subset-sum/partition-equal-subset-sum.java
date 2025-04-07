class Solution {
    private Boolean[][] dp;
    private boolean check(int index, int target, int[] nums)
    {
        if(target == 0)
        return true;

        if(index >= nums.length || target < 0)
        return false;

        if(dp[index][target] != null)
        return dp[index][target];

        return dp[index][target] = check(index + 1, target - nums[index], nums) || check(index + 1, target, nums);
    }

    public boolean canPartition(int[] nums) 
    {
        int Sum = Arrays.stream(nums).sum();
        // return false if Sum not divisible by '2'
        if(Sum % 2 != 0)
        return false;

        int m = Sum / 2;
        dp = new Boolean[nums.length][m + 1];
        return check(0, m, nums);





















        // int n = nums.length;

        // // create dp array
        // boolean[][] dp = new boolean[n + 1][m + 1];

        // // fill the first column
        // for(int i = 0; i < n + 1; i++)
        // dp[i][0] = true;

        // for(int i = 1; i < n + 1; i++)
        // {
        //     for(int j = 1; j < m + 1; j++)
        //     {
        //         if(j - nums[i - 1] >= 0)
        //         dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];

        //         else
        //         dp[i][j] = dp[i - 1][j];
        //     }
        // }
        // return dp[n][m];
    }
}