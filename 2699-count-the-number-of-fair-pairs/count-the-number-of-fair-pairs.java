class Solution {
    private long L, U;

    private int getCeil(int start, int end, int[] nums, int fixed)
    {
        int res = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if((long) nums[mid] + fixed >= L)
            {
                res = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return res;
    }

    private int getFloor(int start, int end, int[] nums, int fixed)
    {
        int res = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if((long) nums[mid] + fixed <= U)
            {
                res = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return res;
    }

    public long countFairPairs(int[] nums, int lower, int upper) 
    {
        L = lower;
        U = upper;
        Arrays.sort(nums);

        long count = 0;
        for(int i = 1; i < nums.length; i++)
        {
            int fixed = nums[i];
            int startIndex = getCeil(0, i - 1, nums, fixed);
            int endIndex = getFloor(0, i - 1, nums, fixed);

            if(startIndex != -1 && endIndex != -1 && startIndex <= endIndex)
                count += (endIndex - startIndex + 1);
        }
        return count;
    }
}
