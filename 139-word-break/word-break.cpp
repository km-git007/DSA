class Solution {
public:
    int dp[301];
    int solve(string s,unordered_set<string> set,int start)
    {
        if(start==s.length())
        return 1;

        if(dp[start]!=-1)
        return dp[start];

        string curr="";
        for(int i=start;i<s.length();i++)
        {
            curr.push_back(s[i]);
            if(set.count(curr))
            {
                if(solve(s,set,i+1))
                return dp[start]=1;
            }
        }
        return dp[start]=0;
    }

    bool wordBreak(string s, vector<string>& wordDict) 
    {
        memset(dp,-1,sizeof(dp));
        unordered_set<string> set(wordDict.begin(),wordDict.end());
        return solve(s,set,0);
    }
};