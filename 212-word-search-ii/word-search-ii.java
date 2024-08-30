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

    public Solution()
    {
        root=new Trie();
    }

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
    

    List<String> ans=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    int n,m;
    private void solve(int row,int col,Trie curr,char[][] board)
    {
        if(row<0 || row>=n || col<0 || col>=m || board[row][col]=='#')
        return;

        char c=board[row][col];

        if(curr.children[c-'a']==null)
        return;
        
        sb.append(c);
        board[row][col]='#';

        curr=curr.children[c-'a'];
        if(curr.isEnd)
        {
            ans.add(sb.toString());
            // to avoid duplicacy.
            curr.isEnd=false;
        }

        solve(row,col-1,curr,board);  //left
        solve(row,col+1,curr,board);   //right
        solve(row-1,col,curr,board);  //up
        solve(row+1,col,curr,board);  //down

        sb.deleteCharAt(sb.length()-1);
        board[row][col]=c;
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