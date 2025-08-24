class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    TrieNode() {
        children = new TrieNode[26];
    }
}

class WordDictionary {

    public WordDictionary() {
        root = new TrieNode();
    }

    private final TrieNode root;
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
    
    public void addWord(String word) {
        insert(word);
    }
    
    private boolean searchWord(TrieNode node, int index, String word) {
        for (int i = index; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(c == '.'){
                for(char ch = 'a'; ch <= 'z' && ch != c; ch++){
                    if(node.children[ch - 'a'] != null && searchWord(node.children[ch - 'a'], i + 1, word)){
                        return true;
                    }
                }
                return false;
            }

            if(node.children[c - 'a'] == null){
                return false;
            }

            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }
    
    public boolean search(String word) {
        return searchWord(root, 0, word);
    }
}
