class Solution {
public:
    bool check(vector<int>& nums) 
    {
        // there should be no or just one violation at the pivot point
        int n = nums.size(), violation = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] > nums[(i + 1) % n])
            violation++;
        }

        return violation <= 1;
    }
};