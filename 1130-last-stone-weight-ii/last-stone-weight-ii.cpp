class Solution {
public:
    int subsetSum(vector<int>& stones, int sum)
    {
        int n = stones.size();
        int m = sum;
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

        // filling the first column
        // first row gets filled with '0's on vector initialization itself
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

        for(int i = sum / 2; i >= 0; i--)
        {
            if(dp[n][i])
            return sum - 2 * i;
        }

        // return whatever the fuck you want
        return -1;
    }

    int lastStoneWeightII(vector<int>& stones) 
    {
        int sum = 0;
        for(int stone : stones)
        sum += stone;

        return subsetSum(stones, sum);
    }
};