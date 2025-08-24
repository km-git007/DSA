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
    
    private boolean searchWord(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c != '.'){
                if(node.children[c - 'a'] == null){
                    return false;
                }
                node = node.children[c - 'a'];
            }else{
                for(char ch = 'a'; ch <= 'z' && ch != c; ch++){
                    String newWord = ch + word.substring(i + 1);
                    if(searchWord(node, newWord)){
                        return true;
                    }
                }
                return false;
            }
        }
        return node.isEnd;
    }
    
    public boolean search(String word) {
        return searchWord(root, word);
    }
}
