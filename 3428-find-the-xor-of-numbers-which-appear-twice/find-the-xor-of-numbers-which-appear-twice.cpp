class Solution {
public:
    int duplicateNumbersXOR(vector<int>& nums) 
    {
        unordered_map<int,int> map;
        for(int num : nums)
        map[num]++;

        int res=0;
        for(auto ele : map)
        {
            if(ele.second==2)
            {
                res=res^ele.first;
            }
        }
        return res;
    }
};