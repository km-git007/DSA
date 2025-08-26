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
    }

    public String replaceWords(List<String> dictionary, String sentence)
    {
        String[] words = sentence.split(" ");
        for(String word : dictionary){
            insert(word);
        }
        
        String[] res = new String[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                String prefix = words[i].substring(0, j + 1);
                if(search(prefix)){
                    res[i] = prefix;
                    break;
                }
            }
            if(res[i] == null){
                res[i] = words[i];
            }
        }
        return String.join(" ", res);
    }
}