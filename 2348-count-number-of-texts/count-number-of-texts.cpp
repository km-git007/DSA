class Solution {
public:
    int MOD;
    vector<int> dp;
    unordered_set<char> set;
    int solve(int index, string &pressedKeys)
    {
        if(index >= pressedKeys.length())
        return 1;

        if(dp[index] != -1)
        return dp[index];

        int times = set.count(pressedKeys[index]) ? 4 : 3;

        int totalWays = 0;
        for(int i = index; i < index + times; i++)
        {
            if(pressedKeys[i] != pressedKeys[index])
            break;

            totalWays = (totalWays + solve(i + 1, pressedKeys) % MOD) % MOD;
        }

        return dp[index] = totalWays;
    }

    int countTexts(string pressedKeys) 
    {
        MOD = 1e9 + 7;
        set = {'7','9'};
        dp = vector<int>(pressedKeys.length(), -1);
        return solve(0, pressedKeys);
    }
};