class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++)
        {
            dp[i] = 1;
            for(int j = 0; j <= i; j++)
            {
                if(nums[i] > nums[j])
                dp[i] = Math.max(1 + dp[j], dp[i]);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}