class Trie {

    private class TrieNode{

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
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            int index = c-'a';

            if(curr.children[index]==null)
            {
                TrieNode node=new TrieNode();
                curr.children[index]=node;
            }
            curr=curr.children[index];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) 
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            int index = c-'a';

            if(curr.children[index]==null)
            return false;

            curr=curr.children[index];
        }
        return curr.isEnd==true;
    }
    
    public boolean startsWith(String prefix) 
    {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c = prefix.charAt(i);
            int index = c-'a';

            if(curr.children[index]==null)
            return false;

            curr=curr.children[index];
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