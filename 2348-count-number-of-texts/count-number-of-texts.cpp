class Solution {
public:
    int countTexts(string pressedKeys) 
    {
        int n = pressedKeys.length(), MOD = 1e9 + 7;
        unordered_set<char> set = {'7','9'};

        vector<int> dp(n + 1);
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--)
        {
            int times = set.count(pressedKeys[i]) ? 4 : 3;
            int totalWays = 0;
            for(int j = i; j < i + times && j < n; j++)
            {
                if(pressedKeys[j] != pressedKeys[i])
                break;

                totalWays = (totalWays + dp[j + 1] % MOD) % MOD;
            }
            dp[i] = totalWays;
        }
        return dp[0];
    }
};