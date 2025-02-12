class Solution {
public:
    int getSum(int num)
    {
        int sum = 0;
        while(num)
        {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    int maximumSum(vector<int>& nums) 
    {
        // Stores the max number for each digit sum
        unordered_map<int, int> map;
    
        int maxSum = -1;
        for(int num : nums)
        {
            int sum = getSum(num);

            // If we already have a number with the same sum, update maxSum
            if(map.count(sum))
            maxSum = max(maxSum, map[sum] + num);
            
            // Store the maximum number for this sum
            map[sum] = max(map[sum], num);
        }
        return maxSum;
    }
};