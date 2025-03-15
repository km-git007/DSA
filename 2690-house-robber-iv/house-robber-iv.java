class Solution {

    private boolean canRob(int[] nums, int k, int capability)
    {
        int housesRobbed = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] <= capability)
            {
                housesRobbed++;
                i++;
            }
        }
        return housesRobbed >= k;
    }

    public int minCapability(int[] nums, int k) 
    {
        int start = Arrays.stream(nums).min().getAsInt();
        int end = Arrays.stream(nums).max().getAsInt();
        int minCapability = end;
        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            if(canRob(nums, k, mid)) 
            {
                minCapability = mid;
                end = mid - 1;
            } 
            else 
            start = mid + 1;
        }
        // return the minCapability
        return minCapability;
    }
}