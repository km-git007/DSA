class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) 
    {
        long long count = 0, zeros = 0;
        for (int num : nums) 
        {
            if (num == 0) 
            {
                zeros++;
                count += zeros;  // Add subarrays ending here
            } 
            else 
            {
                zeros = 0;  // Reset on non-zero
            }
        }
        return count;
    }
};