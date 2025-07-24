class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) 
    {
        unordered_set<int> set;
        int i = 0, n = nums.size();
        int score = 0, maxscore = 0;
        for(int j = 0; j < n; j++)
        {
            while(set.count(nums[j]))
            {
                score -= nums[i];
                set.erase(nums[i]);
                i++;
            }
            set.insert(nums[j]);
            score += nums[j];
            maxscore = max(score, maxscore);
        }
        return maxscore;
    }
};