class Solution {
public:
    int minDistance(string s, string t) 
    {
        int n = s.length();
        int m = t.length();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

         // Fill the first row and column (base cases)
        for (int i = 0; i <= n; i++) dp[i][0] = i; // Deleting characters from `s`
        for (int j = 0; j <= m; j++) dp[0][j] = j; // Inserting characters into `s`

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j < m + 1; j++)
            {
                // characters match
                if(s[i - 1] == t[j - 1])
                dp[i][j] = dp[i - 1][j - 1];

                // characters don't match
                else
                dp[i][j] = 1 + min({dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]});
            }
        }
        return dp[n][m];
    }
};