class Solution {
    public long countSubarrays(int[] nums, int k) 
    {
        int n=nums.length;
        int maxElement=-1;
        for(int num : nums)
        maxElement=Math.max(maxElement,num);

        int i=0;
        long freq=0,count=0;
        for(int j=0;j<n;j++)
        {
            if(nums[j]==maxElement)
            freq++;
            // subarrays ending on jth index.
            while(freq==k)
            {
                if(nums[i]==maxElement)
                freq--;
                i++;
            }
            count+=i;
        }
        return count;
    }
}