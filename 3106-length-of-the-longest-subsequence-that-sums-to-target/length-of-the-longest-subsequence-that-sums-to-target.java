class Solution {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) 
    {
        int n = nums.size();
    int[][] dp = new int[target + 1][n + 1];

    // Initialize the dp array
    for (int i = 0; i <= target; i++) {
        for (int j = 0; j <= n; j++) {
            dp[i][j] = -10000001;  // Use a very small value to denote an invalid state
        }
    }

    // Base case: target is 0, the length of subsequence is 0 for any starting index
    for (int j = 0; j <= n; j++) {
        dp[0][j] = 0;
    }

    // Fill the dp table
    for (int i = 1; i <= target; i++) {  // i represents the current target
        for (int j = n - 1; j >= 0; j--) {  // j represents the index in nums
            dp[i][j] = dp[i][j + 1];  // Skip the current element
            if (i >= nums.get(j)) {
                dp[i][j] = Math.max(dp[i][j], 1 + dp[i - nums.get(j)][j + 1]);  // Include the current element
            }
        }
    }

    int ans = dp[target][0];
    return ans < 0 ? -1 : ans;
    }
}