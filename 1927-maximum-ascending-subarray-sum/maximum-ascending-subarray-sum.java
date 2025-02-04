class Solution {
    public int maxAscendingSum(int[] nums) 
    {
        int maxSum = nums[0];
        int i = 0, sum = nums[0];
        for(int j = 1; j < nums.length; j++)
        {
            if(nums[j - 1] < nums[j])
            sum += nums[j];
            else
            sum = nums[j];

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}