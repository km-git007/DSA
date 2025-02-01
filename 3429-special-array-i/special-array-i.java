class Solution {
    public boolean isArraySpecial(int[] nums) 
    {
        for(int i = 1; i < nums.length; i++)
        {
            if(Math.abs(nums[i] % 2 - nums[i - 1] % 2) == 0)
            return false;
        }

        return true;
    }
}