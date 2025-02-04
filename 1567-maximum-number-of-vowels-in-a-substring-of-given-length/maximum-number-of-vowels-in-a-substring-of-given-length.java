class Solution {
    public int maxVowels(String s, int k) 
    {
        // build a set of vowels
        Set<Character> set = helper();

        int i = 0, count = 0, maxVowels = 0;
        for(int j = 0; j < s.length(); j++)
        {
            if(set.contains(s.charAt(j)))
            count++;
            
            if(j - i + 1 == k)
            {
               // update the maxVowels
               maxVowels = Math.max(count, maxVowels);
               
               // no need to check further
               if(maxVowels == k)
               return k;

               if(set.contains(s.charAt(i)))
               count--;
               
               i++;
            }
        }
        return maxVowels;
    }

    private Set<Character> helper()
    {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        return set;
    }
}