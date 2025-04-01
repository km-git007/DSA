class Solution {
public:
    long long dp[100000];
    long long solve(int index, vector<vector<int>>& questions) 
    {
        if(index >= questions.size())
        return 0;

        if(dp[index] != -1)
        return dp[index];

        long long pick = questions[index][0] + solve(index + questions[index][1] + 1, questions);
        long long skip = solve(index + 1, questions);

        return dp[index] = max(pick, skip);
    }

    long long mostPoints(vector<vector<int>>& questions) 
    {
        memset(dp, -1, sizeof(dp));
        return solve(0, questions);
    }
};