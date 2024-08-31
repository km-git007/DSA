class Solution {

    private HashSet<String> set = new HashSet<>();
    private HashMap<String,Boolean> map = new HashMap<>();

    private boolean solve(String s) 
    {
        // Base case: if the entire string is found in the set
        if(set.contains(s))
        return true;
        
        if(map.containsKey(s))
        return map.get(s);

        // Try breaking the string into two parts and solve recursively
        for(int i = 1; i<s.length(); i++) 
        {  // Use i < s.length() to avoid out-of-bounds
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);

            // Check if the prefix is a valid word and recursively check the suffix
            if (set.contains(prefix) && solve(suffix))
            {
                map.put(s,true);
                return true;
            }
        }
        // If no valid break found, return false
        map.put(s,false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) 
    {
        for(String word : wordDict)
        set.add(word);

        return solve(s);
    }
}