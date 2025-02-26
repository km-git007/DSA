class Solution {
    private int[] kadanesAlgo(int[] nums)
    {
        int currMaxima, currMinima, maxima, minima;
        currMaxima = currMinima = minima = maxima = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            currMaxima = Math.max(nums[i], currMaxima + nums[i]);
            currMinima = Math.min(nums[i], currMinima + nums[i]);
            maxima = Math.max(maxima, currMaxima);
            minima = Math.min(minima, currMinima);
        }
        return new int[]{maxima, minima};
    }

    public int maxAbsoluteSum(int[] nums) 
    {
        int[] extrema = kadanesAlgo(nums);
        return Math.max(extrema[0], -extrema[1]);
    }
}