class WordDictionary {

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

    public WordDictionary() 
    {
        root=new Trie();
    }
    

    public void addWord(String word) 
    {
        Trie curr=root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a']==null)
            curr.children[c-'a']=new Trie();

            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word)
    {
        return searchInNode(word,root);
    } 

    public boolean searchInNode(String word,Trie curr) 
    {
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(c=='.')
            {
                for(Trie child : curr.children)
                {
                    if(child!=null)
                    {
                        if(searchInNode(word.substring(i+1),child))
                        return true;
                    }
                }
                return false;
            }

            if(curr.children[c-'a']==null)
            return false;

            curr=curr.children[c-'a'];
        }
        return curr.isEnd==true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */