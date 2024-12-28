class Solution {
    public int maxSubarraySumCircular(int[] nums) 
    {
        int n = nums.length;
        int totalSum = nums[0], maxSum = nums[0], minSum = nums[0], currMin = nums[0], currMax = nums[0];
        for(int i = 1; i < n ; i++)
        {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum , currMax);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum , currMin);

            totalSum += nums[i];
        }
        
        // Handle edge case where all elements are negative
        if(maxSum < 0) 
        return maxSum;
        
        int maxCircularSum = totalSum - minSum;

        return Math.max(maxSum, maxCircularSum);
    }
}