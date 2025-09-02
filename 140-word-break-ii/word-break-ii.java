class Solution {
    private Set<String> wordSet;
    private List<String> res;
    private void check(String word, StringBuilder sb) {
        if(word.isEmpty()){
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i < word.length(); i++){
            String prefix = word.substring(0, i + 1);
            if(wordSet.contains(prefix)) {
                int length = sb.length();
                String suffix = word.substring(i + 1);
                check(suffix, sb.append(prefix).append(" "));
                sb.setLength(length);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        res = new ArrayList<>();
        check(s, new StringBuilder());
        return res;
    }
}