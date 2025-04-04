class Solution {
public:
    int dp[20];
    int solve(int n)
    {
        if(n == 0 || n == 1)
        return 1;

        if(dp[n] != -1)
        return dp[n];

        int res = 0;
        for(int i = 0; i < n; i++)
        res += solve(i) * solve(n - i - 1);

        return dp[n] = res;
    }

    int numTrees(int n) 
    {
        memset(dp, -1, sizeof(dp));
        return solve(n);
    }
};