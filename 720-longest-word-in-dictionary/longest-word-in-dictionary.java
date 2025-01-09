class Solution {

    private class Trie
    {
        boolean isEnd;
        Trie[] children;
        Trie()
        {
            isEnd = false;
            children = new Trie[26];
        }
    }
    
    private Trie root;

    private void insert(String word) 
    {
        Trie curr=root;
        for(char c : word.toCharArray()) 
        {
            int index=c-'a';
            if(curr.children[index]==null) 
            curr.children[index] = new Trie();

            curr=curr.children[index];
        }
        curr.isEnd=true;
    }

    public Solution()
    {
        root = new Trie();
    }

    private boolean canBuild(String word)
    {
        Trie curr = root;
        for(char c : word.toCharArray())
        {
            int index = c - 'a';
            if(curr.children[index] == null || !curr.children[index].isEnd)
            return false;

            curr = curr.children[index];
        }
        return true;
    }

    public String longestWord(String[] words) 
    {
        for(String word : words)
        insert(word);

        String result = "";
        for(String word : words)
        {
            if(canBuild(word))
            {
                if(word.length() > result.length() || 
                (word.length() == result.length() && word.compareTo(result) < 0))
                result = word;
            }
        }
        return result;
    }
}