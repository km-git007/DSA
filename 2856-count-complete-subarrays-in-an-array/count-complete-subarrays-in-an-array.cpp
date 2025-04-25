class Solution {
public:
    int subarraysLessThanEqualToKDistinct(vector<int>& nums, int k)
    {
        int n = nums.size();
        unordered_map<int, int> map;
        int i = 0, count = 0;
        for(int j = 0; j < n; j++)
        {
            map[nums[j]]++;
            while(map.size() == k)
            {
                count += n - j;

                map[nums[i]]--;
                if(map[nums[i]] == 0)
                map.erase(nums[i]);

                i++;
            }
        }
        return count;
    }

    int countCompleteSubarrays(vector<int>& nums) 
    {
        unordered_set<int> set(nums.begin(), nums.end());
        int distinct = set.size();
        return subarraysLessThanEqualToKDistinct(nums, distinct) - subarraysLessThanEqualToKDistinct(nums, distinct + 1);
    }
};