class Solution {
public:
    int countOfSubarraysWithAtleastK(vector<int>& nums, int k)
    {
        unordered_map<int, int> map;
        int i = 0, count = 0, n = nums.size();
        for(int j = 0; j < n; j++)    
        {
            map[nums[j]]++;
            while(map.size() >= k)
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

    int subarraysWithKDistinct(vector<int>& nums, int k) 
    {
        return countOfSubarraysWithAtleastK(nums, k) - countOfSubarraysWithAtleastK(nums, k + 1);
    }
    
};