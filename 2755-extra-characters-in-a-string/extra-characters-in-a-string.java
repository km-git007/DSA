class Solution {
    public Solution()
    {
        set = new HashSet<>();
    }
    private Set<String> set;
    private Integer[] dp;
    private int solve(String s, int index)
    {
        if(index == s.length())
        return 0;

        if(dp[index] != null)
        return dp[index];

        int minChar = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < s.length(); i++)
        {
            sb.append(s.charAt(i));

            int extraChar = 0;
            if(set.contains(sb.toString()))
            extraChar = solve(s, i + 1);
            else
            extraChar = i - index + 1 + solve(s, i + 1);

            minChar = Math.min(minChar, extraChar);
        }

        return dp[index] = minChar;
    }

    public int minExtraChar(String s, String[] dictionary) 
    {
        for(String word : dictionary)
        set.add(word);

        dp = new Integer[s.length()];
        return solve(s, 0);
    }
}