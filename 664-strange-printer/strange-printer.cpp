class Solution {
public:
    int dp[100][100];
    int solve(string &s,int start,int end)
    {
        if(start==end)
        return 1;

        if(dp[start][end]!=-1)
        return dp[start][end];

        int minimumTurns=INT_MAX;
        for(int k=start;k<end;k++)
        {
            int turns=solve(s,start,k)+solve(s,k+1,end);
            minimumTurns=min(minimumTurns,turns);
        }
        return dp[start][end]=(s[start]==s[end])?minimumTurns-1:minimumTurns;
    }

    int strangePrinter(string s) 
    {
        memset(dp,-1,sizeof(dp));
        return solve(s,0,s.length()-1);
    }
};