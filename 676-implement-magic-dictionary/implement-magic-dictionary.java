class MagicDictionary {

    private class Trie
    {
        boolean isEnd;
        Trie[] children;
        Trie()
        {
            isEnd=false;
            children=new Trie[26];
        }
    }
    
    private Trie root;

    private void insert(String word) 
    {
        Trie curr=root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                Trie node = new Trie();
                curr.children[c - 'a'] = node;
            } 
            curr = curr.children[c - 'a'];       
        }
        curr.isEnd = true;
    }
    
    private boolean searchWord(String word, Trie curr, int index, boolean canChange) 
    {
        if(index == word.length())
        return !canChange && curr.isEnd;
        
        char c = word.charAt(index);
        if(canChange)
        {
            for(char ch = 'a'; ch <= 'z'; ch++)
            {
                if(ch != c && curr.children[ch - 'a'] != null)
                if(searchWord(word, curr.children[ch - 'a'], index + 1, false))
                return true;
            }
        }

        // if(curr.children[c - 'a'] != null  && searchWord(word, curr.children[c - 'a'], index + 1, true))
        // return true;
        // Proceed with the current character if it matches
    if (curr.children[c - 'a'] != null) {
        return searchWord(word, curr.children[c - 'a'], index + 1, canChange);
    }

        return false;
    }

    public MagicDictionary() 
    {
        root = new Trie();
    }
    
    public void buildDict(String[] dictionary) 
    {
        for(String word : dictionary)
        insert(word);
    }
    
    public boolean search(String searchWord) 
    {
        return searchWord(searchWord, root, 0, true);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */