class Solution {
    public int[] resultsArray(int[] nums, int k) 
    {
        if(nums.length == 1 || k == 1)
        return nums;

        int count = 1, i = 0;
        int[] ans = new int[nums.length - k + 1];
        for(int j = 1; j < nums.length; j++)
        {
            if(nums[j] == nums[j-1] + 1)
            count++;
            else
            count = 1;

            if(j - i + 1 == k)
            {
                if(count >= k)
                ans[i] = nums[j];
                else
                ans[i] = -1;

                i++;
            }
        }
        return ans;
    }
}