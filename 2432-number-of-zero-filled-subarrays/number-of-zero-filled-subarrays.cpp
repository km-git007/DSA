class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) 
    {
        long long count = 0;
        int i = 0;
        while(i < nums.size())
        {
            if(nums[i] == 0)
            {
                int length = 1;
                while(i < nums.size() && nums[i] == 0)
                {
                    count += length;
                    length++;
                    i++;
                }
            }
            else
            i++;
        }
        return count;
    }
};