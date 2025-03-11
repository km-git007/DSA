class Solution {
    public int numberOfSubstrings(String word) 
    {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, i = 0;
        for (int j = 0; j < n; j++) 
        {
            char ch = word.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) 
            {
                count += (n - j);

                char ithChar = word.charAt(i);
                map.put(ithChar, map.get(ithChar) - 1);
                
                if(map.get(ithChar) == 0)
                map.remove(ithChar);

                i++;
            }
        }
        return count;
    }
}