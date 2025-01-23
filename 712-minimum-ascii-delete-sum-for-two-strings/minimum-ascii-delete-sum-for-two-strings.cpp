class Solution {
public:
    int dp[1001][1001];
    int helper(int index, string &s)
    {
        int sum = 0;
        while(index > 0)
        {
            sum += (int)s[index - 1];
            index--;
        }
        return sum;
    }

    int solve(int i, int j, string &s, string &t)
    {
        if(j == 0)
        return helper(i, s);

        if(i == 0)
        return helper(j, t);

        if(dp[i][j] != -1)
        return dp[i][j];

        // characters match
        if(s[i - 1] == t[j - 1])
        dp[i][j] = solve(i - 1, j - 1, s, t);

        // characters don't match
        else
        {
            int a = (int)t[j - 1], b = (int)s[i - 1];

            int del1 = a + solve(i, j - 1, s, t);
            int del2 = b + solve(i - 1, j, s, t);
            int delBoth = a + b + + solve(i - 1, j - 1, s, t);

            // Return the minimum of the three operations
            dp[i][j] = min({del1, del2, delBoth});
        }

        return dp[i][j];
    }

    int minimumDeleteSum(string s1, string s2) 
    {
        memset(dp, -1, sizeof(dp));
        return solve(s1.length(), s2.length(), s1, s2);
    }
};