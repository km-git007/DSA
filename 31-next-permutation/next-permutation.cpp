class Solution {
public:
    void nextPermutation(vector<int>& nums) 
    {
        int index = -1, n = nums.size();
        for(int i = n - 1; i >= 1; i--)
        {
            if(nums[i - 1] < nums[i])
            {
                index = i - 1;
                break;
            }
        }

        if(index != -1)
        {
            for(int i = n - 1; i >= index + 1; i--)
            {
                if(nums[index] < nums[i])
                {
                    swap(nums[index], nums[i]);
                    break;
                }
            }
        }
        sort(nums.begin() + index + 1, nums.end());
    }
};