class Solution {
    public int maxWidthRamp(int[] nums) 
    {
        int n = nums.length;
        int[] maxRightValue = new int[n];
        int maxi = -1;
        for(int i=n-1; i>=0; i--)
        {
            if(nums[i] > maxi)
            maxi = nums[i];
            maxRightValue[i] = maxi;
        }

        int j=0;
        int ramp=-1;
        for(int i=0;i<n && j<n;i++)
        {
            while(j<n && maxRightValue[j]>=nums[i])
            {
                ramp=Math.max(ramp,j-i);
                j++;
            }
        }
        return ramp;
    }
}