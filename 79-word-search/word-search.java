class Solution {
    int n,m;
    private boolean dfs(int row,int col,int index,char[][] board, String word)
    {
        if(index==word.length())
        return true;

        if(row<0 || row>=n || col<0 || col>=m || board[row][col]=='#' || word.charAt(index)!=board[row][col])
        return false;

        char originalCharacter=board[row][col];
        board[row][col]='#';

        boolean up=dfs(row-1,col,index+1,board,word);
        boolean down=dfs(row+1,col,index+1,board,word);
        boolean right=dfs(row,col+1,index+1,board,word);
        boolean left=dfs(row,col-1,index+1,board,word);

        board[row][col]=originalCharacter;
        return up || down || right || left;
    }

    public boolean exist(char[][] board, String word) 
    {
        n=board.length;
        m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                if(dfs(i,j,0,board,word))
                return true;
            }
        }
        return false;
    }
}