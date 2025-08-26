class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    PriorityQueue<String> suggestions; // keep top 3 lexicographically

    TrieNode() {
        children = new TrieNode[26];
        suggestions = new PriorityQueue<>((a, b) -> b.compareTo(a)); // max-heap
    }

    void addSuggestion(String word) {
        suggestions.offer(word);
        if (suggestions.size() > 3) {
            suggestions.poll(); // remove lexicographically largest
        }
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
            node.addSuggestion(word);
        }
        node.isEnd = true;
    }

    private List<List<String>> search(String word) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                // prefix not found -> add empty lists for remaining characters
                while (result.size() < word.length()) {
                    result.add(new ArrayList<>());
                }
                return result;
            }
            node = node.children[c - 'a'];
            List<String> list = new ArrayList<>(node.suggestions);
            // ensure lexicographic order
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

    Solution(){
        root = new TrieNode();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        for(String word: products){
            insert(word);
        }
        return search(searchWord);
    }
}