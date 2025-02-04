class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int maxLength = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0; j < s.length(); j++)
        {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() < j - i + 1)
            {
                // remove 1 occurance the ith number from the map
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                // if no more occurance of the its number is left than remove it from the map
                if(map.get(s.charAt(i)) == 0)
                map.remove(s.charAt(i));

                i++;
            }

            if(map.size() == j - i + 1)
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}