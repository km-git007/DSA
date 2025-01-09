class Solution {
    private boolean check(String s, String word)
    {
        if(s.length() < word.length())
        return false;

        for(int i = 0; i < word.length(); i++)
        {
            if(s.charAt(i) != word.charAt(i))
            return false;
        }
        return true;
    }

    public int countPrefixes(String[] words, String s) 
    {
        int count = 0;
        for(String word : words)
        count += (check(s, word) ? 1 : 0);
        
        return count;
    }
}