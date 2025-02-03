class Solution {
    public int findMaxK(int[] nums) 
    {
        int n = nums.length, maxi = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            if(set.contains(-nums[i]))
            maxi = Math.max(maxi, Math.abs(nums[i]));
            
            set.add(nums[i]);
        }
        return maxi == Integer.MIN_VALUE ? -1 : maxi;
    }
}