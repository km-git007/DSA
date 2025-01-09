class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        // to make sure thet binary search is applied on the shorter array
        if(nums1.length > nums2.length)
        return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length;
        int m = nums2.length;

        // range of number of elements to take from the smaller array
        int start = 0, end = n;
        while(start <= end)
        {
            // 'mid' i.e number of elements taken from first array
            int Px = start + (end - start)/2;
            // number of elements taken from second array
            int Py = (m + n + 1)/2 - Px;

            int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px - 1];
            int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py - 1];

            int x3 = (Px == n) ? Integer.MAX_VALUE : nums1[Px];
            int x4 = (Py == m) ? Integer.MAX_VALUE : nums2[Py];

            if(x1 <= x4 && x2 <= x3)
            {
                if((m + n) % 2 == 0)
                return ((double)Math.max(x1, x2) + (double)Math.min(x3, x4)) / 2;

                return (double)Math.max(x1, x2);
            }

            else if(x1 > x4)
            end = Px - 1;

            else
            start = Px + 1;
        }
        return -1;
    }
}