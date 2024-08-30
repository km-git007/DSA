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
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            int index = c-'a';

            if(curr.children[index]==null)
            {
                Trie node=new Trie();
                curr.children[index]=node;
            }
            curr=curr.children[index];
        }
        curr.isEnd=true;
    }
    
    private Trie search(char c,Trie curr) 
    {
        if(curr.children[c-'a']!=null)
        {
            curr=curr.children[c-'a'];

            if(curr.isEnd)
            {
                ans.add(sb.toString());
                curr.isEnd=false;
            }

            return curr;
        }
        return null;
    }

    public Solution()
    {
        root=new Trie();
    }

    List<String> ans=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    int n,m;
    private void solve(int row,int col,Trie curr,char[][] board)
    {
        if(row<0 || row>=n || col<0 || col>=m || board[row][col]=='#')
        return;

        char originalChar=board[row][col];
        sb.append(originalChar);
        board[row][col]='#';

        Trie node=search(originalChar,curr);
        if(node!=null)
        {
            solve(row,col-1,node,board);  //left
            solve(row,col+1,node,board);   //right
            solve(row-1,col,node,board);  //up
            solve(row+1,col,node,board);  //down
        }

        sb.deleteCharAt(sb.length()-1);
        board[row][col]=originalChar;
    }

    public List<String> findWords(char[][] board, String[] words) 
    {
        for(String word : words)
        insert(word);

        n=board.length;
        m=board[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                solve(i,j,root,board);
            }
        }
        return ans;
    }
}