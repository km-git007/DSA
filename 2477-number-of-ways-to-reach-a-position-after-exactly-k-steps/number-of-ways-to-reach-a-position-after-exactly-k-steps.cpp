class Solution {
public:

    int MOD=1e9+7;
    int dp[3001][3001];
    int end,start;
    int solve(int steps,int position)
    {
        if(position==end && steps==0)
        return 1;

        if(steps==0)
        return 0;

        if(dp[steps][position]!=-1)
        return dp[steps][position];

        int left=solve(steps-1,position-1);

        int right=solve(steps-1,position+1);

        int totalWays=(right%MOD + left%MOD)%MOD;
        return dp[steps][position]=totalWays;
    }

    int numberOfWays(int startPos,int endPos,int k) 
    {
        int offset=1000;
        start=startPos+offset;
        end=endPos+offset;
        memset(dp,-1,sizeof(dp));
        return solve(k,start);
    }
};