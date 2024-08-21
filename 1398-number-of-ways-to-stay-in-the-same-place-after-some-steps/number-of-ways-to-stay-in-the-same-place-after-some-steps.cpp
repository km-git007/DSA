class Solution {
public:
    int MOD=1e9+7;
    int dp[501][501];
    int solve(int steps,int position,int end)
    {
        if(position==1 && steps==0)
        return 1;

        if(steps==0)
        return 0;

        if(dp[steps][position]!=-1)
        return dp[steps][position];

        int stay=solve(steps-1,position,end);

        int left=0,right=0;
        if(position>1)
        left=solve(steps-1,position-1,end);

        if(position<end)
        right=solve(steps-1,position+1,end);

        int totalWays=((stay%MOD + left%MOD)%MOD + right%MOD)%MOD;
        return dp[steps][position]=totalWays;
    }

    int numWays(int steps, int arrLen) 
    {
        memset(dp,-1,sizeof(dp));
        return solve(steps,1,arrLen);
    }
};