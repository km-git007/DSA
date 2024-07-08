class Solution {
    public long countSubarrays(int[] nums, long k) 
    {
        long count=0,sum=0;
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            sum+=nums[j];
            while(sum*(j-i+1)>=k)
            {
                sum-=nums[i];
                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}