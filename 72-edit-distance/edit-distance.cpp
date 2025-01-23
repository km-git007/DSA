class Solution {
public:
    int dp[501][501];
    int solve(int i, int j, string &s, string &t)
    {
        if(j == 0)
        return i;

        if(i == 0)
        return j;

        if(dp[i][j] != -1)
        return dp[i][j];

        // characters match
        if(s[i - 1] == t[j - 1])
        dp[i][j] = solve(i - 1, j - 1, s, t);

        // characters don't match
        else
        {
            int replace = 1 + solve(i - 1, j - 1, s, t);
            int dele = 1 + solve(i - 1, j, s, t);
            int insert = 1 + solve(i, j - 1, s, t);

            // Return the minimum of the three operations
            dp[i][j] = min({replace, dele, insert});
        }

        return dp[i][j];
    }

    int minDistance(string word1, string word2) 
    {
        memset(dp, -1, sizeof(dp));
        return solve(word1.length(), word2.length(), word1, word2);
    }
};