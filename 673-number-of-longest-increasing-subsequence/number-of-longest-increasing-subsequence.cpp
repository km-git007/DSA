class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) 
    {
        int n = nums.size();

        // every number can for 1 LIS of length '1' starting and ending on itself
        vector<int> dp(n, 1), count(n, 1);

        int maxLength = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] <= nums[j])
                continue;

                if(dp[i] < dp[j] + 1)
                {
                    count[i] = count[j];
                    dp[i] = dp[j] + 1;
                }

                else if(dp[i] == dp[j] + 1)
                count[i] += count[j];
            }
            maxLength = max(maxLength, dp[i]);
        }

        // Sum all ways to build LIS of length maxLen
        int maxCount = 0;
        for (int i = 0; i < n; i++) 
        {
            if(dp[i] == maxLength)
            maxCount += count[i];
        }
        return maxCount;
    }
};