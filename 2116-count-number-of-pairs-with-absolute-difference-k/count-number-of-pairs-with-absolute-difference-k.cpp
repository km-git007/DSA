class Solution {
public:
    int countKDifference(vector<int>& nums, int k) 
    {
        unordered_map<int,int> map;
        int count=0;
        for(int num : nums)
        {
            if(map[num+k]>0 || map[num-k]>0)
            {
                count+=map[num+k]+map[num-k];
            }
            map[num]++;
        }
        return count;
    }
};