class Solution {

    public int countPartitions(int[] nums) 
    {
        int sum = 0;
        for(int num : nums)
        sum += num;

        int pSum = 0, count = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            pSum += nums[i];
            if(Math.abs(sum - 2 * pSum) % 2 == 0)
            count++;
        }
        return count;
    }
}