class Solution {
    private Set<String> wordSet;
    private Map<String, Integer> dp;
    private int longestChain(String word){
        if(word.isEmpty()) 
        return 0;
        
        if(dp.containsKey(word)) 
        return dp.get(word);
        
        int maxLen = 1;
        for(int i = 0; i < word.length(); i++){
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if(wordSet.contains(newWord)){
                maxLen = Math.max(maxLen, 1 + longestChain(newWord));
            }
        }
        dp.put(word, maxLen);
        return maxLen;
    }
    
    public int longestStrChain(String[] words) {
        dp = new HashMap<>();

        // add all the words in the set
        wordSet = new HashSet<>();
        wordSet.addAll(Arrays.asList(words));
        
        int longestChainLength = 0;
        for(String word : words){
            longestChainLength = Math.max(longestChain(word), longestChainLength);
        }
        return longestChainLength;
    }
}