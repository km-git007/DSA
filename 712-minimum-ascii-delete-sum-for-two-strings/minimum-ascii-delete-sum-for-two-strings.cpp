class Solution {
public:
    int minimumDeleteSum(string s, string t) 
    {
        int n = s.length();
        int m = t.length();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

         // Fill the first row and column 
        for (int i = 1; i <= n; i++) dp[i][0] = (int)s[i - 1] + dp[i - 1][0]; 
        for (int j = 1; j <= m; j++) dp[0][j] = (int)t[j - 1] + dp[0][j - 1]; 

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j < m + 1; j++)
            {
                int a = (int)t[j - 1], b = (int)s[i - 1];
    
                // characters don't match
                if(s[i - 1] != t[j - 1])
                dp[i][j] = min({a + b + dp[i - 1][j - 1], a + dp[i][j - 1], b + dp[i - 1][j]});

                // characters match
                else
                dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }
};