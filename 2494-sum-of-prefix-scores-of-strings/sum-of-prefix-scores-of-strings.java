class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    int prefixScore;
    TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution {
    Solution(){
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
            node.prefixScore++;
        }
        node.isEnd = true;
    }
    
    private int getPrefixScore(String word) {
        TrieNode node = root;
        int prefixScore = 0;
        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];
            prefixScore += node.prefixScore;
        }
        return prefixScore;
    }

    public int[] sumPrefixScores(String[] words) {
        for(String word : words){
            insert(word);
        }
        
        int [] prefixScores = new int[words.length];
        int index = 0;
        for(String word : words){
            prefixScores[index++] = getPrefixScore(word);
        }
        return prefixScores;
    }
}