class Solution {
    public int missingNumber(int[] nums) 
    {
        int res = 0;
        for(int num : nums)
        res = res ^ num;

        for(int i = 0; i <= nums.length; i++)
        res = res ^ i;

        return res;
    }
}