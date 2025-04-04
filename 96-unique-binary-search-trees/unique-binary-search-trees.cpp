class Solution {
public:
    int numTrees(int n) 
    {
        vector<int> dp(n + 1, 0);
        dp[0] = dp[1] = 1; 

        // Bottom-up DP computation
        for(int node = 2; node <= n; node++) 
        {
            for(int root = 0; root < node; root++) 
            dp[node] += dp[root] * dp[node - 1 - root];
        }

        return dp[n]; 
    }
};