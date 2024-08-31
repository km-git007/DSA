class Solution {

    private class Trie{

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
            int index=c-'a';
            if(curr.children[index]==null) 
            curr.children[index] = new Trie();

            curr=curr.children[index];
        }
        curr.isEnd=true;
    }

    public Solution()
    {
        root=new Trie();
    }

    private String ans= "";
    private StringBuilder sb=new StringBuilder();
    private void solve(Trie curr)
    {
        if(curr==null)
        return;

        String temp=sb.toString();
        if(temp.length()>ans.length() || (temp.length()==ans.length() && temp.compareTo(ans)<0))
        ans=temp;

        for(int i=0;i<26;i++)
        {
            if(curr.children[i]!=null && curr.children[i].isEnd)
            {
                sb.append((char)('a' + i));
                solve(curr.children[i]);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public String longestWord(String[] words) 
    {
        for(String word : words)
        insert(word);

        solve(root);
        return ans;
    }
}