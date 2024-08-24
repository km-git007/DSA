class Solution {

    private int MOD=1000000007;
    int[][] dp=new int[31][1001];
    private int solve(int n,int target,int k)
    {
        if(n==0 && target==0)
        return 1;

        if(n==0)
        return 0;

        if(dp[n][target]!=-1)
        return dp[n][target];

        int ways=0;
        for(int i=1;i<=k;i++)
        {
            if(target>=i)
            ways=(ways%MOD+solve(n-1,target-i,k)%MOD)%MOD;
        }
        return dp[n][target]=ways;
    }

    public int numRollsToTarget(int n, int k, int target) 
    {
        for(int i=0;i<31;i++)
        Arrays.fill(dp[i],-1);

        return solve(n,target,k);
    }
}