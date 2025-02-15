class Solution {
    private boolean isValid(int[] nums, int maxCap)
    {
        long sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            if(sum > (long)maxCap * (i + 1))
            return false;
        }
        return true;
    }

    public int minimizeArrayValue(int[] nums) 
    {
        int start = nums[0];
        int end = Arrays.stream(nums).max().getAsInt();
        int minMaxValue = end;
        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            if(isValid(nums, mid)) 
            {
                minMaxValue = mid;
                end = mid - 1;
            } 
            else 
            start = mid + 1;
        }
        // return the ans
        return minMaxValue;
    }
}