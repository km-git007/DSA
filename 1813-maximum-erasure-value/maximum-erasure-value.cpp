class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) 
    {
        bool seen[10001];
        int i = 0, n = nums.size();
        int score = 0, maxscore = 0;
        for(int j = 0; j < n; j++)
        {
            while(seen[nums[j]])
            {
                score -= nums[i];
                seen[nums[i++]] = false;
            }
            seen[nums[j]] = true;
            score += nums[j];
            maxscore = max(score, maxscore);
        }
        return maxscore;
    }
};