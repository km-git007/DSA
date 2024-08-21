class Solution {
public:
    int mod=1e9+7;
    int dp[501][501];
    int solve(int steps,int pos,int end)
    {
        if(pos==1 && steps==0)
        return 1;

        if(steps==0 || pos<1)
        return 0;

        if(dp[steps][pos]!=-1)
        return dp[steps][pos];

        int stay=solve(steps-1,pos,end);

        int left=0,right=0;
        if(pos>1)
        left=solve(steps-1,pos-1,end);

        if(pos<end)
        right=solve(steps-1,pos+1,end);

        int totalWays=((stay%mod + left%mod)%mod + right%mod)%mod;
        return dp[steps][pos]=totalWays;
    }

    int numWays(int steps, int arrLen) 
    {
        memset(dp,-1,sizeof(dp));
        return solve(steps,1,arrLen);
    }
};