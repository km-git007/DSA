class Solution {

    private boolean isValid(int num, boolean considerZero)
    {
        return considerZero ? num >= 0 : num > 0;
    }

    private int binarySearch(int[] nums, boolean considerZero)
    {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(isValid(nums[mid], considerZero))
            end = mid - 1;

            else
            start = mid + 1;
        }
        return start;
    }

    public int maximumCount(int[] nums) 
    {
        int n = nums.length;
        // First positive index => count of positives
        int pos = n - binarySearch(nums, false);
        // First non-negative index => count of negative
        int neg = binarySearch(nums, true);

        return Math.max(neg, pos);
    }
}