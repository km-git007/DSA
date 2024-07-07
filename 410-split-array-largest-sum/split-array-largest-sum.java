class Solution {

    public boolean isValidPartition(int[] nums,int k,int minSum)
    {
        int partitions=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>minSum)
            {
                partitions++;
                sum=nums[i];
            }
            if(partitions>k)
            return false;
        }
        return true;
    }

    public int splitArray(int[] nums,int k) 
    {
        int sum=Arrays.stream(nums).sum();  // Calculate the sum of all elements in nums
        int end=sum;
        int start=Arrays.stream(nums).max().orElse(0);  // Find the maximum element in nums

        int minimumSumSubarray=end;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isValidPartition(nums,k,mid))
            {
                minimumSumSubarray=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }  
        return minimumSumSubarray;
    }
}