class Solution {
    public int longestMonotonicSubarray(int[] nums) 
    {
        int maxIncLength = 1, maxDecLength = 1;
        int l1 = 1, l2 = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i - 1])
            {
                l1++;
                maxIncLength = Math.max(maxIncLength, l1);
            }
            else
            l1 = 1;

            if(nums[i] < nums[i - 1])
            {
                l2++;
                maxDecLength = Math.max(maxDecLength, l2);
            }
            else
            l2 = 1;
        }

        return Math.max(maxIncLength, maxDecLength);
    }
}