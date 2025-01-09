class Solution {

    private class TrieNode
    {
        boolean isEnd;
        int count;
        TrieNode[] children;
        TrieNode()
        {
            count = 0;
            isEnd=false;
            children=new TrieNode[26];
        }
    }
    
    private TrieNode root;

    public Solution() 
    {
        root=new TrieNode();
    }

    private void insert(String word) 
    {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                TrieNode node = new TrieNode();
                curr.children[c - 'a'] = node;
            }
            curr.children[c - 'a'].count++;  
            curr = curr.children[c - 'a'];       
        }
        curr.isEnd = true;
    }
    
    private int startsWith(String prefix) 
    {
        TrieNode curr=root;
        for(char c : prefix.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            return 0;

            curr = curr.children[c - 'a'];
        }
        return curr.count;
    }

    public int prefixCount(String[] words, String prefix) 
    {
        for(String word : words)
        insert(word);

        return startsWith(prefix);
    }
}