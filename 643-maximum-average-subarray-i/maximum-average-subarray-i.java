class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
        int i = 0;
        double sum = 0, maxAverage = -Double.MAX_VALUE;
        for(int j = 0; j < nums.length; j++)
        {
            sum += nums[j];
            if(j - i + 1 == k)
            {
                double average = sum / k;
                maxAverage = Math.max(average, maxAverage);

                sum -= nums[i];
                i++;
            }
        }
        return maxAverage;
    }
}