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

    private void addWord(String word) 
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

    private boolean check(String word,Trie curr,boolean changeAllowed)
    {
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            int index = c-'a';

            // Explore all possible changes, even if the current character matches
            if(changeAllowed) 
            {
                // Try changing the current character to any other character
                for(int j = 0; j < 26; j++) 
                {
                    if(j != index && curr.children[j] != null) 
                    {
                        if(check(word.substring(i + 1), curr.children[j], false))
                        return true;
                    }
                }
            }
            
            // If the current character matches, continue the search
            if(curr.children[index] != null)
            curr = curr.children[index];

            // No match found
            else 
            return false; 
        }
        // Return true if the word is found and exactly one change has been made.
        return curr.isEnd==true && !changeAllowed;
    }


    public MagicDictionary() 
    {
        root=new Trie();
    }
    
    public void buildDict(String[] dictionary) 
    {
        for(String word : dictionary)
        addWord(word);
    }
    
    public boolean search(String searchWord) 
    {
        return check(searchWord,root,true);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */