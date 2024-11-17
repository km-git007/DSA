class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) 
    {
        int n = nums.size();
        long long pSum = 0; // Prefix sum
        int minLength = INT_MAX;

        deque<pair<long long, long long>> dq; // Stores {prefix sum, index}
        dq.push_back({0, -1}); // Initialize with prefix sum 0 at index -1

        for (int i = 0; i < n; i++) 
        {
            pSum += nums[i];

            // Shrink the window
            while (!dq.empty() && pSum - dq.front().first >= k) {
                minLength = min(minLength, i - (int)dq.front().second);
                dq.pop_front();
            }

            // Maintain deque order: remove elements with a higher prefix sum
            // that are less useful for forming valid subarrays
            while (!dq.empty() && dq.back().first >= pSum) {
                dq.pop_back();
            }

            // Add the current prefix sum and index
            dq.push_back({pSum, i});
        }
        return minLength==INT_MAX ? -1 : minLength;
    }
};