class Solution {
public:
    int countSubarrays(vector<int>& nums) 
    {
        int n = nums.size(), count = 0;
        for(int j = 0; j <= n - 3; j++)
        {
            if(2 * (nums[j] + nums[j + 2]) == nums[j + 1])
            count++;
        }
        return count;
    }
};