class Solution {
public:
    int countPairs(vector<int>& nums, int k) 
    {
        unordered_map<int, unordered_set<int>> map;
        int pairs = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            if(map.count(nums[i]) > 0)
            {
                auto indexSet = map[nums[i]];
                for(int index : indexSet)
                {
                    if(index * i % k == 0)
                    pairs++;
                }
            }
            map[nums[i]].insert(i);
        }
        return pairs;
    }
};