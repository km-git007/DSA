class Solution {

    public Solution()
    {
        root=new Trie();
    }

    private class Trie
    {
        Trie[] children;
        int count;
        Trie()
        {
            count=0;
            children=new Trie[26];
        }
    }
    
    private Trie root;

    private void insert(String word)
    {
        Trie curr=root;
        for(char c : word.toCharArray())
        {
            if (curr.children[c-'a'] == null)
            curr.children[c-'a']=new Trie(); 

            curr=curr.children[c-'a'];
            curr.count+=1;
        }
    }

    // returns the score of a word.
    private int scoreOfWord(String word) 
    {
        Trie curr=root;
        int score=0;
        for(char c : word.toCharArray())
        {
            curr=curr.children[c-'a'];
            score+=curr.count;
        }
        return score;
    }

    public int[] sumPrefixScores(String[] words) 
    {
        for(String word : words)
        insert(word);

        int[] ans=new int[words.length];
        int index=0;
        for(String word : words)
        {
            int score=scoreOfWord(word);
            ans[index++]=score;
        }
        return ans;
    }
}