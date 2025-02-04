class Solution {
public:
    int dp[301];
    unordered_set<string> set;
    int solve(string &s, int start)
    {
        if(start == s.length())
        return true;

        if(dp[start] != -1)
        return dp[start];

        string curr="";
        for(int i = start; i < s.length(); i++)
        {
            curr.push_back(s[i]);
            if(set.count(curr) && solve(s,i+1))
            return 1;
        }
        // return false
        return dp[start]=0;
    }

    bool wordBreak(string s, vector<string>& wordDict) 
    {
        memset(dp,-1,sizeof(dp));

        for(string word : wordDict)
        set.insert(word);
        
        return solve(s,0);
    }
};