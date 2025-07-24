class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) 
    {
        unordered_map<int, int> map;
        int i = 0, n = nums.size();
        int score = 0, maxscore = 0;
        for(int j = 0; j < n; j++)
        {
            map[nums[j]]++;
            score += nums[j];
            while(j - i + 1 > map.size())
            {
                score -= nums[i];
                map[nums[i]]--;
            
                if(!map[nums[i]])
                map.erase(nums[i]);

                i++;
            }
            maxscore = max(score, maxscore);
        }
        return maxscore;
    }
};