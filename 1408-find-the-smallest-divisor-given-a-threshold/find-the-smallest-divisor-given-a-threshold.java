class Solution {
    
    public boolean isValidPartition(int[] nums,int threshold,int divisor)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=Math.ceil((double)nums[i]/divisor);
            if(sum>threshold)
            return false;
        }
        return true;
    }

    public int smallestDivisor(int[] nums, int threshold) 
    {
        int end=Arrays.stream(nums).max().orElse(0);;
        int start=1;

        int requiredDivisor=-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isValidPartition(nums,threshold,mid))
            {
                requiredDivisor=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }  
        return requiredDivisor;
    }
}