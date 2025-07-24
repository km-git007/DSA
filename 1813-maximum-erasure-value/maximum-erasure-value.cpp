class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) 
    {
        unordered_set<int> seen;
        int i = 0, n = nums.size();
        int score = 0, maxscore = 0;
        for(int j = 0; j < n; j++)
        {
            while(seen.count(nums[j]))
            {
                score -= nums[i];
                seen.erase(nums[i++]);
            }
            seen.insert(nums[j]);
            score += nums[j];
            maxscore = max(score, maxscore);
        }
        return maxscore;
    }
};