class Solution {
public:
    bool isMonotonic(vector<int>& nums) 
    {
        bool increasing = true, decreasing = true;

        for(int i = 1; i < nums.size(); i++) 
        {
            if (nums[i] > nums[i - 1]) // Not non-increasing
            decreasing = false;
            if (nums[i] < nums[i - 1]) // Not non-decreasing
            increasing = false;
        }

        return increasing || decreasing; // True if at least one condition holds
    }
};