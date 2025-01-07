class Solution {
    private int[][] dp;
    private int solve(int[] nums, int index, int target)
    {
        if(target == 0)
        return 1;

        if(target < 0 || index < 0)
        return 0;

        if(dp[index][target] != -1)
        return dp[index][target];

        int take = solve(nums, index - 1, target - nums[index]);
        int notTake = solve(nums, index - 1, target);

        if(take > 0 || notTake > 0)
        return dp[index][target] = 1;

        return dp[index][target] = 0;
    }

    public boolean canPartition(int[] nums) 
    {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0)
        return false;

        dp = new int[nums.length + 1][sum / 2 + 1];
        for(int i = 0; i < nums.length + 1; i++)
        Arrays.fill(dp[i], -1);

        return solve(nums, nums.length - 1, sum / 2) == 1;
    }
}