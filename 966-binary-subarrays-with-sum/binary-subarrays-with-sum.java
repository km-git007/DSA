class Solution {
    private int numSubarraysWithSumAtLeastK(int[] nums, int k) {
        int count = 0, i = 0, sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= k && i <= j) {
                count += nums.length - j;
                sum -= nums[i];
                i++;
            }
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        return numSubarraysWithSumAtLeastK(nums, goal) - numSubarraysWithSumAtLeastK(nums, goal + 1);
    }
}