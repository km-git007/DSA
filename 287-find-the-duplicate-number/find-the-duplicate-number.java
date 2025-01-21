class Solution {
    public int findDuplicate(int[] nums) 
    {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            if(i == nums[i])
            return nums[i];
        }
        return -1;
    }
}