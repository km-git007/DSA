class Solution {
    public int maxVowels(String s, int k) 
    {
        // build a set of vowels
        Set<Character> set = helper();

        int i = 0, count = 0, maxVowel = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int j = 0; j < s.length(); j++)
        {
            if(set.contains(s.charAt(j)))
            {
                count++;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }

            if(j - i + 1 == k)
            {
               // update the maxVowel
               maxVowel = Math.max(count, maxVowel);

               if(set.contains(s.charAt(i)))
               {
                    // remove 1 occurance the ith character from the map
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    // if no more occurance of the its character is left than remove it from the map
                    if(map.get(s.charAt(i)) == 0)
                    map.remove(s.charAt(i));

                    count--;
               }
               i++;
            }
        }
        return maxVowel;
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