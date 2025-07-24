class Solution {
    public int characterReplacement(String s, int k)
    {
         int [] map = new int[26];
        int maxCount = 0;
        int i = 0, maxLength = 0;
        for(int j = 0; j < s.length(); j++)
        {
            maxCount = Math.max(maxCount, ++map[s.charAt(j)-'A']);
            while(j - i + 1 - maxCount > k)
            {
                maxCount = Math.max(maxCount, --map[s.charAt(i)-'A']);
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}