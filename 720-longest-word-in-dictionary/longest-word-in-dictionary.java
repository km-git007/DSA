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

    private boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }
    
    Solution(){
        root = new TrieNode();
        sb = new StringBuilder();
        maxLen = 0;
        longestWord = "";
    }

    private StringBuilder sb;
    private int maxLen;
    private String longestWord;
    private void dfs(TrieNode root){
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(root.children[ch - 'a'] != null && root.children[ch - 'a'].isEnd){
                sb.append(ch);
                dfs(root.children[ch - 'a']);
                if(sb.length() > maxLen){
                    maxLen = sb.length();
                    longestWord = sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }
        dfs(root);
        return longestWord;
    }
}