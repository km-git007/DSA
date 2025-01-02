class Solution {
public:
    bool increasingTriplet(vector<int>& nums) 
    {
        int a = INT_MAX, b = INT_MAX;
        for(int num : nums)
        {
            if(num > a && num > b)
            return true;

            else if(num > a && num <= b)
            b = num;

            else if(num <= a && num < b)
            a = num;
        }
        return false;
    }
};