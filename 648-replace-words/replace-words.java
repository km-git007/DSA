class Solution {
    public String replaceWords(List<String> dictionary, String sentence)
    {
        Set<String> wordSet = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word : words){
            boolean match = false;
            for(int i = 0; i < word.length(); i++){
                String prefix = word.substring(0, i + 1);
                if(wordSet.contains(prefix)){
                    sb.append(prefix).append(" ");
                    match = true;
                    break;
                }
            }
            if(!match){
                sb.append(word).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}