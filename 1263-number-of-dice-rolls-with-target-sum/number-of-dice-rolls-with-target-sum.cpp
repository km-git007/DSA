class Solution {
public:
    int MOD = 1000000007;
    long dp[31][1001];
    int solve(int n, int target, int k)
    {
        if(n == 0 && target == 0)
        return 1;

        if(n == 0)
        return 0;

        if(dp[n][target] != -1)
        return dp[n][target];

        int ways = 0;
        for(int i = 1; i <= k; i++)
        if(target - i >= 0)
        ways = ((ways % MOD) + (solve(n - 1, target - i, k) % MOD)) % MOD;

        return dp[n][target] = ways;
    }

    int numRollsToTarget(int n, int k, int target) 
    {
        memset(dp, -1, sizeof(dp));
        return (int)solve(n, target, k);
    }
};