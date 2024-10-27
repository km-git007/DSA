class Solution {
    
    private int n, m;
    private String targetWord;
    private int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private boolean dfs(int row,int col,int index,char[][] board)
    {
        if(index == targetWord.length())
        return true;

        if(row < 0 || row >= n || col < 0 || col >=m || board[row][col] != targetWord.charAt(index))
        return false;

        char c = board[row][col];
        board[row][col] = '#';

        for( int[] dir : directions)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(dfs(newRow, newCol, index + 1, board))
            return true;
        }
        
        // backtrack
        board[row][col] = c;
        return false;
    }

    public boolean exist(char[][] board, String word) 
    {
        n=board.length;
        m=board[0].length;
        targetWord = word;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                if(dfs(i,j,0,board))
                return true;
            }
        }
        return false;
    }
}