class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) 
    {
        int n = questions.size();

        if(n == 1)
        return questions[0][0];

        long long dp[100000];
        dp[n - 1] = questions[n - 1][0];
        dp[n - 2] = max(questions[n - 1][0], questions[n - 2][0]);

        for(int i = n - 3; i >= 0; i--)
        {
            long long take = questions[i][0]; 

            if(i + questions[i][1] + 1 < n)
            take += dp[i + questions[i][1] + 1];

            long long skip = dp[i + 1];

            dp[i] = max(take, skip);
        }

        return dp[0];
    }
};