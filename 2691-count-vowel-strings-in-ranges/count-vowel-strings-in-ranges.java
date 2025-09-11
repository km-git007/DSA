class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowelStringsCount = new  int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            char startingChar = words[i].charAt(0);
            char endingChar = words[i].charAt(words[i].length() - 1);
            boolean isVowelString = isVowel(startingChar) && isVowel(endingChar);
            vowelStringsCount[i + 1] += vowelStringsCount[i] + (isVowelString ? 1 : 0);
        }

        int[] res = new int[queries.length];
        int index = 0;
        for(int[] query : queries){
            int start = query[0] + 1;
            int end = query[1] + 1;
            res[index++] = vowelStringsCount[end]- vowelStringsCount[start - 1];
        }
        return res;
    }
}