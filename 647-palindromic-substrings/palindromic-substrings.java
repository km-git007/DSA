class Solution {
    private int dp[][]=new int[1001][1001];
    private int isPallindrome(String s,int start,int end)
    {
        if(start>=end)
        return 1;

        if(dp[start][end]!=-1)
        return dp[start][end];

        if(s.charAt(start)!=s.charAt(end))
        return dp[start][end]=0;

        return dp[start][end]=isPallindrome(s,start+1,end-1);
    }

    private int solve(String s,int start)
    {
        int pStrings=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(isPallindrome(s,i,j)==1)
                pStrings++;
            }
        }
        return pStrings;
    }

    public int countSubstrings(String s) 
    {
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);

        return solve(s,0);
    }
}