class Solution {
public:
    vector<int> subsetSum(vector<int>& stones, int sum)
    {
        int n = stones.size();
        int m = sum;
        vector<vector<int>> dp(n + 1, vector<int>(m + 1));

        // filling the first row
        for(int j = 0; j <= m; j++)
        dp[0][j] = 0;

        // filling the first column
        for(int i = 0; i <= n; i++)
        dp[i][0] = 1;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m ; j++)
            {
                if(stones[i - 1] <= j)
                dp[i][j] = dp[i - 1][j - stones[i - 1]] || dp[i - 1][j];

                else
                dp[i][j] = dp[i - 1][j];
            }
        }

        vector<int> arr;
        for(int i = 0; i <= sum / 2; i++)
        {
            if(dp[n][i])
            arr.push_back(i);
        }
        return arr;
    }

    int lastStoneWeightII(vector<int>& stones) 
    {
        int sum = 0;
        for(int stone : stones)
        sum += stone;

        vector<int> arr = subsetSum(stones, sum);

        int minWeight = INT_MAX;
        for(int num : arr)
        minWeight = min(minWeight, sum - 2 * num);

        return minWeight;
    }
};