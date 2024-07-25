class Solution {
public:

    int n,m;
    void dfs(int row,int col,vector<vector<int>>& grid,vector<vector<int>>& vis,int &count)
    {
        if(row<0 or row>=n or col<0 or col>=m or grid[row][col]==0 or vis[row][col]==1)
        return;

        vis[row][col]=1;    // marking the current row and column as visited.
        count++;

        dfs(row-1,col,grid,vis,count);
        dfs(row,col+1,grid,vis,count);
        dfs(row+1,col,grid,vis,count);
        dfs(row,col-1,grid,vis,count);
    }

    int maxAreaOfIsland(vector<vector<int>>& grid) 
    {
        n=grid.size();
        m=grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        int maxCount=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=0;
                if(grid[i][j]==1 and vis[i][j]==0)
                {
                    dfs(i,j,grid,vis,count);
                    maxCount=max(maxCount,count);
                }
            }
        }
        return maxCount;
    }
};