class Solution {
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        int longestLen = 0;
        String longestWord = "";
        for (String word : words) {
            int currLen = 0;
            for(int i = 0; i < word.length(); i++){
                if(!wordSet.contains(word.substring(0, i + 1))){
                    break;
                }
                currLen++;
            }
            String currWord = word.substring(0, currLen);
            if(currLen > longestLen || (currLen == longestLen && currWord.compareTo(longestWord) <= 0)){
                longestLen = currLen;
                longestWord = currWord;
            }
        }
        return longestWord;
    }
}