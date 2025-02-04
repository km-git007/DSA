class Solution {

    private HashSet<String> set = new HashSet<>();
    private Boolean[] dp;
    private boolean solve(int index, String s) 
    {
        if(index >= s.length())
        return true;
        
        if(dp[index] != null)
        return dp[index];

        for(int i = index + 1; i <= s.length(); i++) 
        {  
            String prefix = s.substring(index, i);

            // Check if the prefix is a valid word and recursively check the remaining string
            if (set.contains(prefix) && solve(i, s))
            return true;
        }
        // If no valid break found, return false
        return dp[index] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) 
    {
        for(String word : wordDict)
        set.add(word);

        dp = new Boolean[s.length() + 1];

        return solve(0, s);
    }
}