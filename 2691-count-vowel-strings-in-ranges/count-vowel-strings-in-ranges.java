class Solution {

    private boolean isVowel(char c) 
    {
        return "aeiou".indexOf(c) != -1;
    }

    public int[] vowelStrings(String[] words, int[][] queries) 
    {
        int n = words.length;
        int[] pSum = new int[n + 1];
        pSum[0] = 0;

        for(int i = 0; i < n; i++)
        {
            boolean isVowelString = isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1));
            pSum[i + 1] = pSum[i] + (isVowelString ? 1 : 0);
        }

        int[] res = new int[queries.length];
        int index = 0;
        for(int[] query : queries)
        {
            int start = query[0] + 1, end = query[1] + 1;
            res[index++] = pSum[end] - pSum[start - 1];
        }
        return res;
    }
}