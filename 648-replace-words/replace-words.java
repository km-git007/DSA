class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution {
 private TrieNode root;
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    private String findShortestPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return word;
            }
            node = node.children[c - 'a'];
            if(node.isEnd){
                return word.substring(0, i + 1);
            }
        }
        // control would never reach here
        return word;
    }

    Solution(){
        root = new TrieNode();
    }

    public String replaceWords(List<String> dictionary, String sentence)
    {
        String[] words = sentence.split(" ");
        for(String word : dictionary){
            insert(word);
        }
        
        String[] res = new String[words.length];
        int index = 0;
        for(String word : words){
            res[index++] = findShortestPrefix(word);
        }
        return String.join(" ", res);
    }
}