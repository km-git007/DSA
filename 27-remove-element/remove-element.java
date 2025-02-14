class Solution {
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElement(int[] nums, int val) 
    {
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
            {
                swap(nums, i, index);
                index++;
            }
        }
        return index;
    }
}