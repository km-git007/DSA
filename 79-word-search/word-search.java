class Solution {
    
    private int n, m;
    private char[] targetWord;
    private int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private boolean dfs(int row, int col, int index, char[][] board)
    {
        if(index >= targetWord.length)
        return true;

        if(row < 0 || row >= n || col < 0 || col >= m || board[row][col] == '#' || board[row][col] != targetWord[index])
        return false;

        board[row][col] = '#';
        for(var dir : directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            if(dfs(r, c, index + 1, board))
            return true;
        }

        board[row][col] = targetWord[index];
        return false;
    }

    public boolean exist(char[][] board, String word) 
    {
        n = board.length;
        m = board[0].length;
        targetWord = word.toCharArray();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(board[i][j] == word.charAt(0))
                if(dfs(i,j,0,board))
                return true;
            }
        }
        return false;
    }
}