class Solution {
    private Set<String> wordSet;
    private Map<String, Boolean> dp;
    private boolean check(String word) {
        if(wordSet.contains(word)) return true;
        if(dp.containsKey(word)) return dp.get(word);
        for(int i = 0; i < word.length(); i++){
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1);
            if(wordSet.contains(prefix) && check(suffix)){
                dp.put(word, true);
                return true;
            }
        }
        dp.put(word, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return check(s);
    }
}