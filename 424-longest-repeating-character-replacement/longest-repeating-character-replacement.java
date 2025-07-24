class Solution {
    public int characterReplacement(String s, int k)
    {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int i = 0, maxLength = 0;
        for(int j = 0; j < s.length(); j++)
        {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(j)));
            while(j - i + 1 - maxCount > k)
            {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                maxCount = Math.max(maxCount, map.get(s.charAt(i)));
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}