class Solution {

    private int n,m;
    private int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private void dfs(int row,int col,char[][] board)
    {
        if(row < 0 || row >= n || col < 0 || col >=m || board[row][col]!='O')
        return;

        // masking the current cell
        board[row][col]='#';

        for( int[] dir : directions)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(newRow, newCol, board);
        }
    }

    public void solve(char[][] board) 
    {
        n=board.length;
        m=board[0].length;
        // start DFS from all the 'O' at the boundary and these cells will 
        // only retain their original state 'O'.
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && (i == 0 || i == n-1 || j==0 || j==m-1))
                dfs(i,j,board);
            } 
        }

        // change rest of the O's to 'X'
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O')
                board[i][j]='X';
                else if(board[i][j]=='#')
                board[i][j]='O';
            } 
        }
    }
}