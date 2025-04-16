class Solution {
    public int findLength(int[] nums1, int[] nums2) 
    {
        int n = nums1.length, m = nums2.length; 
        int[] curr = new int[m + 1], prev = new int[m + 1];

        int maxLength = 0;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(nums1[i - 1] == nums2[j - 1])
                curr[j] = 1 + prev[j - 1];
                
                else
                curr[j] = 0; // ✅ Important reset step!

                maxLength = Math.max(maxLength, curr[j]);
            }

            for(int j = 1; j <= m; j++)
            prev[j] = curr[j];
        }
        return maxLength;
    }
}