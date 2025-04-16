class Solution {
    private boolean isSubsequence(String s, String word) 
    {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) 
        {
            if(s.charAt(i) == word.charAt(j))
            j++;
            i++;
        }
        return j == word.length();
    }

    public int numMatchingSubseq(String s, String[] words) 
    {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int wordFrequency = entry.getValue();
            if (isSubsequence(s, word)) {
                count += wordFrequency;
            }
        }
        return count;
    }
}