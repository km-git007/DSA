class Solution {
    public int findNumberOfLIS(int[] nums) 
    {
        int n = nums.length;
        int[] dp = new int[n];     // Length of LIS ending at i
        int[] count = new int[n];  // Number of LIS ending at i
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (nums[i] > nums[j]) 
                {
                    if (dp[j] + 1 > dp[i]) 
                    {
                        dp[i] = dp[j] + 1;
                        // take the count from j
                        count[i] = count[j]; 
                    } 
                    else if (dp[j] + 1 == dp[i]) 
                    {
                        // add more ways
                        count[i] += count[j]; 
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        // Sum all ways to build LIS of length maxLen
        int result = 0;
        for (int i = 0; i < n; i++) 
        {
            if(dp[i] == maxLen)
            result += count[i];
        }

        return result;
    }
}