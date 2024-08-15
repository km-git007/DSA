class Solution {
public:
    int dp[301];
    int solve(string s,unordered_set<string> set,int start)
    {
        if(start==s.length())
        return 1;

        if(dp[start]!=-1)
        return dp[start];

        for(int length=1;length<=s.length()-start;length++)
        {
            if(set.count(s.substr(start,length)))
            {
                if(solve(s,set,start+length))
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