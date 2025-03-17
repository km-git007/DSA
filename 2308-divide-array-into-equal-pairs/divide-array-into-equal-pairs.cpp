class Solution {
public:
    bool divideArray(vector<int>& nums) 
    {
        unordered_map<int, int> map;
        for(int num : nums)
        map[num]++;

        for(auto ele : map)
        {
            if(ele.second % 2 != 0)
            return false;
        }
        
        return true;
    }
};