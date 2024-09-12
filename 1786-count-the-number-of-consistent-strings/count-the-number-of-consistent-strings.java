class Solution {

    private HashSet<Character> set=new HashSet<>();
    private boolean check(String s)
    {
        for(char c : s.toCharArray())
        if(!set.contains(c))
        return false;

        return true;
    }

    public int countConsistentStrings(String allowed, String[] words) 
    {
        for(char c : allowed.toCharArray())
        set.add(c);

        int count=0;
        for(String word : words)
        {
            if(check(word))
            count++;
        }
        return count;
    }
}