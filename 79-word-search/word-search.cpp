class Solution {
public:
    int n,m;
    vector<pair<int,int>> dir={{0,-1},{0,1},{-1,0},{1,0}};
    bool dfs(int row,int col,vector<vector<char>>& board, string word,int i)
    {
        if(i==word.length())
        return true;

        if(row>=n || row<0 ||col>=m || col<0)
        return false;

        if(board[row][col]==word[i])
        {
            board[row][col]='#';
            for(int j=0;j<4;j++)
            {
                int nRow=row+dir[j].first;
                int nCol=col+dir[j].second;
                if(dfs(nRow,nCol,board,word,i+1))
                return true;
            }
            board[row][col]=word[i];
        }
        return false;
    }

    bool exist(vector<vector<char>>& board, string word) 
    {
        m=board[0].size();
        n=board.size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(dfs(i,j,board,word,0))
                return true;
            }
        }
        return false;
    }
};