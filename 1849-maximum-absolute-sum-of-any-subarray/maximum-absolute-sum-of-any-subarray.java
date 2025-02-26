class Solution {
    private int kadanesAlgo(int[] nums, boolean findMax)
    {
        int currExtrema = nums[0];
        int maxExtrema = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            currExtrema = findMax ? Math.max(nums[i], currExtrema + nums[i]) : Math.min(nums[i], currExtrema + nums[i]);
            maxExtrema = findMax ? Math.max(maxExtrema, currExtrema) : Math.min(maxExtrema, currExtrema);
        }
        return maxExtrema;
    }

    public int maxAbsoluteSum(int[] nums) 
    {
        int maxSubarraySum = kadanesAlgo(nums, true);
        int minSubarraySum = kadanesAlgo(nums, false);
        return Math.max(maxSubarraySum, Math.abs(minSubarraySum));
    }
}