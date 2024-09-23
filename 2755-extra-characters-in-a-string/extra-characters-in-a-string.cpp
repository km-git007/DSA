class Solution {
private:
    unordered_set<string> set;
    int dp[51];
    int solve(string &s,int start)
    {
        if(start==s.length())
        return 0;

        if(dp[start]!=-1)
        return dp[start];

        int result=1+solve(s,start+1);

        string curr="";
        for(int i=start;i<s.length();i++)
        {
            curr.push_back(s[i]);
            if(set.count(curr))
            {
                result=min(result,solve(s,i+1));
            }
        }
        return dp[start]=result;
    }

public:
    int minExtraChar(string s, vector<string>& dictionary) 
    {
        for(string word : dictionary)
        set.insert(word);

        memset(dp,-1,sizeof(dp));
        return solve(s,0);
    }
};