class Solution {
    public int minimizeArrayValue(int[] nums) 
    {
        long sum = 0, minMaxValue = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            minMaxValue = Math.max(minMaxValue, (long)Math.ceil((double)sum / (i + 1)));
        }
        return (int)minMaxValue;
    }
}