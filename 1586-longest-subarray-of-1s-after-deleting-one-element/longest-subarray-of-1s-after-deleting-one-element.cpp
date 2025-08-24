class Solution {
public:
    int longestSubarray(vector<int>& nums) 
    {
        int n = nums.size();
        int zeroes = 0, maxLength = 0, i = 0;
        for(int j = 0; j < n; j++)
        {
            if(nums[j] == 0)
            zeroes++;

            while(zeroes > 1)
            {
                if(nums[i] == 0)
                zeroes--;

                i++;
            }

            maxLength = max(maxLength, j - i + 1);
        }
        return maxLength - 1;
    }
};