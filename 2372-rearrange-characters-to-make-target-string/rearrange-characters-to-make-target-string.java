class Solution {
    public int rearrangeCharacters(String s, String target) 
    {
        Map<Character, Integer> map1 = new HashMap<>();
        for(char ch : target.toCharArray())
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            // check if the character is present in the target string
            if(map1.containsKey(ch))
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // all the characters in target word are not present in 's'
        if(map.size() < map1.size())
        return 0;

        int copies = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) 
        {
            char key = entry.getKey();
            // if the target is 'blossoms' then it contains 1 - {'b', 'l', 'm'}, 2 - {'o'}, 3 - {'s'}
            // then we have to divide the value by the num of occurances in the map1.
            int value = entry.getValue() / map1.get(key);

            copies = Math.min(copies, value);
        }
        return copies;
    }
}