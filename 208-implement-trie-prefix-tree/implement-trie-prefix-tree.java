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
    

    private void recursiveInsert(String word, TrieNode curr, int index) 
    {
        if(index == word.length())
        {
            curr.isEnd = true;
            return;
        }

        char c = word.charAt(index);

        if(curr.children[c - 'a'] == null)
        curr.children[c - 'a'] = new TrieNode();

        recursiveInsert(word, curr.children[c - 'a'], index + 1);
    }

    private boolean recursiveSearch(String word, TrieNode curr, int index) 
    {
        if(index == word.length()) 
        return curr.isEnd == true;

        char c = word.charAt(index);
        
        if(curr.children[c - 'a'] == null)
        return false;

        return recursiveSearch(word, curr.children[c - 'a'], index + 1);
    }

    private boolean recursivePrefixSearch(String prefix, TrieNode curr, int index) 
    {
        if(index == prefix.length()) 
        return true;

        char c = prefix.charAt(index);
        
        if(curr.children[c - 'a'] == null)
        return false;

        return recursivePrefixSearch(prefix, curr.children[c - 'a'], index + 1);
    }

    public void insert(String word) 
    {
        recursiveInsert(word, root, 0);
    }
    
    public boolean search(String word) 
    {
        return recursiveSearch(word, root, 0);
    }
    
    public boolean startsWith(String prefix) 
    {
        return recursivePrefixSearch(prefix, root, 0);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */