class Solution {
    public long zeroFilledSubarray(int[] nums) 
    {
        long count = 0; // To count the total number of subarrays
        long consecutiveZeros = 0; // To count consecutive zeros

        for (int num : nums) 
        {
            if (num == 0) 
            {
                // Increment the count for each zero
                consecutiveZeros++;
                // Add all subarrays ending at this zero 
                count += consecutiveZeros; 
            } else 
            {
                // Reset if the current number is not zero
                consecutiveZeros = 0; 
            }
        }

        return count;
    }
}