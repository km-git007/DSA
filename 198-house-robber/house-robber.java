class Solution {
    private int[] dp;
    private int solve(int[] nums, int index)
    {
        if(index < 0)
        return 0;

        if(index == 0)
        return nums[0];

        if(dp[index] != -1)
        return dp[index];

        int take = nums[index] + solve(nums,index - 2);

        int notTake = solve(nums,index - 1);

        return dp[index] = Math.max(take, notTake);
    }

    public int rob(int[] nums) 
    {
        dp = new int [nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, nums.length - 1);
    }
}