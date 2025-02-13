class Solution {
    public List<Integer> findAnagrams(String s, String p) 
    {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++)
        map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);

        int i = 0, count = map.size();
        List<Integer> res = new ArrayList<>();
        for(int j = 0; j < s.length(); j++)
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if(map.get(ch) == 0)
                count--;
            }

            if(j - i + 1 == p.length())
            {
                if(count == 0)
                res.add(i);

                if(map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    if(map.get(s.charAt(i)) == 1)
                    count++;
                }
                i++;
            }
        }
        return res;
    }
}