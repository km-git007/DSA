class Solution {
    private Integer[][] dp;
    private int solve(int prev, int curr, int[] nums)
    {
         // Base case: if we have exhausted the list
        if (curr == nums.length) {
            return 0;
        }

        // Check if the result is already memoized
        if (dp[prev + 1][curr] != null) {
            return dp[prev + 1][curr]; // prev is shifted by 1 for ease of indexing
        }

        // Option 1: Skip the current element
        int exclude = solve(prev, curr + 1, nums);

        // Option 2: Include the current element (if possible)
        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solve(curr, curr + 1, nums); // Include current element
        }

        // Memoize the result
        dp[prev + 1][curr] = Math.max(include, exclude);
        return dp[prev + 1][curr];
    }

    public int lengthOfLIS(int[] nums) 
    {
        dp = new Integer[nums.length + 1][nums.length];
        return solve(-1, 0, nums);
    }
}