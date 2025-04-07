class Solution {
    public boolean canPartition(int[] nums) 
    {
        int Sum = Arrays.stream(nums).sum();
        // return false if Sum not divisible by '2'
        if(Sum % 2 != 0)
        return false;

        int sum = Sum / 2;
        int n = nums.length;

        // create dp array
        // first row is set to false i.e all elements of prev is set to false
        boolean[] prev = new boolean[sum + 1], curr = new boolean[sum + 1];
        // boolean[] curr = new boolean[sum + 1];

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 0; j < sum + 1; j++)
            {
                // first column is always true
                if(j == 0)
                curr[j] = true;

                else if(j - nums[i - 1] >= 0)
                curr[j] = prev[j - nums[i - 1]] || prev[j];

                else
                curr[j] = prev[j];
            }
            // assign curr to prev
            for(int j = 0; j < sum + 1; j++)
            prev[j] = curr[j];
        }
        return prev[sum];
    }
}