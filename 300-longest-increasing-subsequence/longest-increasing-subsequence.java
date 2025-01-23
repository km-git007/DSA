class Solution {
    private Integer[][] dp;
    private int solve(int prev, int curr, int[] nums)
    {
        if(curr == nums.length)
        return 0;

        if(prev == -1)
        return Math.max(1 + solve(curr, curr + 1, nums), solve(prev, curr + 1, nums));

        if(dp[prev][curr] != null)
        return dp[prev][curr];

        int include = Integer.MIN_VALUE;
        if(nums[curr] > nums[prev])
        include = 1 + solve(curr, curr + 1, nums);

        int exclude = solve(prev, curr + 1, nums);

        return dp[prev][curr] = Math.max(include, exclude);
    }

    public int lengthOfLIS(int[] nums) 
    {
        dp = new Integer[nums.length][nums.length];
        return solve(-1, 0, nums);
    }
}