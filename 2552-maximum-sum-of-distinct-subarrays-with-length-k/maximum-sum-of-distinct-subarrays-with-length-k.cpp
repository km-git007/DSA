class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) 
    {
        unordered_set<int> seen;
        int i = 0;
        long long sum = 0, maxSum = 0;
        for (int j = 0; j < nums.size(); ++j) 
        {
            // shrink the window if there's a duplicate
            while(seen.count(nums[j])) {
                seen.erase(nums[i]);
                sum -= nums[i++];
            }

            sum += nums[j];
            seen.insert(nums[j]);

            if(j - i + 1 == k) 
            {
                maxSum = max(maxSum, sum);

                sum -= nums[i];
                seen.erase(nums[i++]);
            }
        }
        return maxSum;
    }
};