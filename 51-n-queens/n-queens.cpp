class Solution {
public:
    int n;
    vector<vector<string>> ans;
    int queen[9];          // gives the col no in which the queen is placed in ith row.
    void solve(int i,vector<string> &board)
    {
        if(i==n)
        {
            ans.push_back(board);
            return;
        }

        for(int j=0;j<n;j++)
        {
            if(check(i,j))
            {
                board[i][j]='Q';
                queen[i]=j;
                solve(i+1,board);
                board[i][j]='.';
                queen[i]=0;
            }
        }
    }

    bool check(int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            int qRow=i;
            int qCol=queen[i];

            if(qCol==col || abs(row-qRow)==abs(col-qCol))
            return false;
        }
        return true;
    }

    vector<vector<string>> solveNQueens(int boardSize) 
    {
        n=boardSize;
        // memset(queen,-1,sizeof(queen));
        vector<string> board(n,string(n,'.'));

        solve(0,board);
        return ans;
    }
};