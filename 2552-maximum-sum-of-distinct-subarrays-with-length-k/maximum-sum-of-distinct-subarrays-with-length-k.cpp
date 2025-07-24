class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) 
    {
        unordered_map<int, int> map;
        int i = 0;
        long long sum = 0, maxSum = 0;
        for (int j = 0; j < nums.size(); ++j) 
        {
            sum += nums[j];
            map[nums[j]]++;
            if(j - i + 1 == k) 
            {
                if(j - i + 1 == map.size())
                maxSum = max(maxSum, sum);

                sum -= nums[i];
                map[nums[i]]--;

                if(!map[nums[i]])
                map.erase(nums[i]);
                i++;
            }
        }
        return maxSum;
    }
};