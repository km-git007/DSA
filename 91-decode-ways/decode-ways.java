class Solution {
    private int[] dp;
    private int solve(String s,int index)
    {
        if(index == s.length())
        return 1;

        if(s.charAt(index) == '0')
        return 0;

        if(dp[index] != -1)
        return dp[index];

        int ways = solve(s, index + 1);

        if(index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26)
        ways += solve(s, index + 2);

        return dp[index] = ways;
    }

    public int numDecodings(String s) 
    {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        // if(s.charAt(0) != '0')
        // dp[0] = 1;

        // if(n > 1 && s.charAt(1) != '0')


        return solve(s, 0);
    }
}