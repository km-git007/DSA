class Solution {
public:
    bool check(int row, int col, char c, vector<vector<char>>& board)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==c || board[row][i]==c)
            return false;
        }

        int startRow=row-row%3;
        int startCol=col-col%3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[startRow+i][startCol+j]==c)
                return false;
            }
        }
        return true;
    }

    bool solve(int row, int col, vector<vector<char>>& board)
    {
        if(row == 9)
        return true;

        if(col > 8)
        return solve(row + 1, 0, board);

        if(board[row][col] != '.')
        return solve(row, col + 1, board);
        
        for(char num = '1'; num <= '9'; num++)
        {
            if(check(row, col, num, board))
            {
                board[row][col] = num;
                
                if(solve(row, col + 1, board))
                return true;

                board[row][col] = '.';
            }
        }
        return false;
    }

    void solveSudoku(vector<vector<char>>& board) 
    {
        solve(0, 0, board);
        return;
    }
};