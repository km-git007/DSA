class Solution {
public:
    void dfs(int row,int col,vector<vector<char>>& grid,vector<vector<int>>& vis)
    {
        int n=grid.size();
        int m=grid[0].size();
        if(row<0 or row>=n or col<0 or col>=m or grid[row][col]=='0' or vis[row][col]==1)
        return;

        vis[row][col]=1;    // marking the current row and column as visited.

        dfs(row-1,col,grid,vis);
        dfs(row,col+1,grid,vis);
        dfs(row+1,col,grid,vis);
        dfs(row,col-1,grid,vis);

        return;
    }

    int numIslands(vector<vector<char>>& grid) 
    {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' and vis[i][j]==0)
                {
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
};