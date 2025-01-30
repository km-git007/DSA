class Solution {
public:
    int dp[1001][2001];
    int solve(int index, int coins, vector<vector<int>>& piles)
    {
        if(index == piles.size())
        return 0;

        if(dp[index][coins] != -1)
        return dp[index][coins];

        // no coins taken from the current pile
        int notTake = solve(index + 1, coins, piles);

        int take = 0, total = 0;
        // coins taken from the current pile
        for(int i = 0; i < piles[index].size() && i < coins; i++)
        {
            total += piles[index][i];
            take = max(take, total + solve(index + 1, coins - (i + 1), piles));
        }

        return dp[index][coins] = max(take, notTake);
    }

    int maxValueOfCoins(vector<vector<int>>& piles, int k) 
    {
        memset(dp, -1, sizeof(dp));
        return solve(0, k, piles);
    }
};