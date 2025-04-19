class Solution {
public:
    long long countGood(vector<int>& nums, int k) 
    {
        unordered_map<int, int> map;
        int i = 0, n = nums.size();
        long long pairs = 0, count = 0;
        for(int j = 0; j < n; j++)
        {
            map[nums[j]]++;
            pairs += map[nums[j]] - 1;

            while(pairs >= k)
            {
                // count subarrays starting from ith index
                count += n - j;

                // update pairs
                map[nums[i]]--;
                pairs -= map[nums[i]];

                if(map[nums[i]] == 0)
                map.erase(nums[i]);

                i++;
            }
        }
        return count;
    }
};