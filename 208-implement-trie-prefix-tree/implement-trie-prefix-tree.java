class Trie {

    private class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;
        TrieNode()
        {
            isEnd=false;
            children=new TrieNode[26];
        }
    }
    
    private TrieNode root;

    public Trie() 
    {
        root=new TrieNode();
    }
    

    public void insert(String word) 
    {
        TrieNode curr=root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                TrieNode node = new TrieNode();
                curr.children[c - 'a'] = node;
            } 
            curr = curr.children[c - 'a'];       
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) 
    {
        TrieNode curr=root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            return false;

            curr = curr.children[c - 'a'];  
        }
        return curr.isEnd == true;
    }
    
    public boolean startsWith(String prefix) 
    {
        TrieNode curr=root;
        for(char c : prefix.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            return false;

            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */