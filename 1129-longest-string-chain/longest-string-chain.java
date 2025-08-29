class Solution {    
    public int longestStrChain(String[] words) 
    {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int maxChainLength = 1;    
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, 1);
            int currentChainLength = 1;
            for(int i = 0; i < word.length(); i++){
                String previousWord = word.substring(0, i) + word.substring(i + 1);
                currentChainLength = Math.max(currentChainLength, map.getOrDefault(previousWord, 0) + 1);
            }
            map.put(word, currentChainLength);
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }
        return maxChainLength;
    }
}