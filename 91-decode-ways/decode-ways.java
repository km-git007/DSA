class Solution {
    private int[] dp;
    private int solve(String s,int index)
    {
        if(index == s.length())
        return 1;

        if(dp[index] != -1)
        return dp[index];

        int ways = 0;

        if(s.charAt(index) != '0')
        ways += solve(s, index + 1);

        if(index + 1 < s.length())
        {
            if(s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))
            ways += solve(s, index + 2);
        }

        return dp[index] = ways;
    }

    public int numDecodings(String s) 
    {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s, 0);
    }
}