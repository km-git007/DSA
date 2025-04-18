class Trie {

    private class TrieNode
    {
        boolean isEnd;
        int value;
        TrieNode[] children;
        TrieNode()
        {
            isEnd = false;
            this.value = 0;
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;

    public Trie() 
    {
        root = new TrieNode();
    }
    

    public void insert(String word, int val) 
    {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                TrieNode node = new TrieNode();
                curr.children[c - 'a'] = node;
            } 
            curr = curr.children[c - 'a'];     
            curr.value += val;  
        }
        curr.isEnd = true;
    }
    
    public int findSum(String prefix) 
    {
        TrieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            return 0;

            curr = curr.children[c - 'a'];
        }
        return curr.value;
    }
}

class MapSum {

    private Trie trie; 
    private Map<String, Integer> map;
    public MapSum() 
    {
        trie = new Trie(); 
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) 
    {
        int delta = val - map.getOrDefault(key, 0); // calculate the change
        map.put(key, val);                          // update the key's value
        trie.insert(key, delta);                    // insert the delta only
    }
    
    public int sum(String prefix) 
    {
        return trie.findSum(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */