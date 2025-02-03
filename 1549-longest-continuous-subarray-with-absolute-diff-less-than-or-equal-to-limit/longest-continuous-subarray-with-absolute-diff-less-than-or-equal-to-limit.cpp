class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) 
    {
        deque<int> minDq, maxDq;
        int i = 0, maxLength = 0, n = nums.size();
        for(int j = 0; j < n; j++)
        {
            while(!minDq.empty() && nums[j] < minDq.back())
            minDq.pop_back();

            while(!maxDq.empty() && nums[j] > maxDq.back())
            maxDq.pop_back();

            minDq.push_back(nums[j]);
            maxDq.push_back(nums[j]);

            while(maxDq.front() - minDq.front() > limit)
            {
                if(nums[i] == minDq.front())
                minDq.pop_front();

                if(nums[i] == maxDq.front())
                maxDq.pop_front();

                i++;
            }
            maxLength = max(maxLength, j - i + 1);
        }
        return maxLength;
    }
};