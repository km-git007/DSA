class Solution {
    private int dp[][] = new int[1001][1001];
    private int isPalindrome(String s, int start, int end)
    {
        if(start >= end)
        return 1;

        if(dp[start][end] != -1)
        return dp[start][end];

        if(s.charAt(start) != s.charAt(end))
        return dp[start][end]=0;

        return dp[start][end] = isPalindrome(s, start + 1, end - 1);
    }

    private int solve(String s)
    {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                if(isPalindrome(s,i,j) == 1)
                count++;
            }
        }
        return count;
    }

    public int countSubstrings(String s) 
    {
        for(int i = 0; i < dp.length; i++)
        Arrays.fill(dp[i], -1);

        return solve(s);
    }
}