class Solution {
    private Integer[][] dp;
    private int solve(int curr, int next, int[] nums)
    {
        // Base case: if we have exhausted the list
        if(curr < 0)
        return 0;

        if (dp[curr][next] != null)
        return dp[curr][next]; 

        // Option 1: Skip the current element
        int exclude = solve(curr - 1, next, nums);

        // Option 2: Include the current element (if possible)
        int include = 0;
        if (next == nums.length || nums[curr] < nums[next])
        include = 1 + solve(curr - 1, curr, nums); 

        // Memoize the result and return 
        return dp[curr][next] = Math.max(include, exclude);
    }

    public int lengthOfLIS(int[] nums) 
    {
        dp = new Integer[nums.length + 1][nums.length + 1];
        return solve(nums.length - 1, nums.length, nums);
    }
}