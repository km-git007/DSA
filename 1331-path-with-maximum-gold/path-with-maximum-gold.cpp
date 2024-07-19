class Solution {
public:
    int n,m;
    int solve(vector<vector<int>>& grid,int i,int j)
    {
        if(i>=n or j>=m or i<0 or j<0 or grid[i][j]==0)
        return 0;

        int gold=grid[i][j];
        grid[i][j]=0;                 // marking the grid as visited.

        int up=solve(grid,i-1,j);
        int down=solve(grid,i+1,j);
        int left=solve(grid,i,j-1);
        int right=solve(grid,i,j+1);

        grid[i][j]=gold;

        // return grid[i][j] + std::max({up, down, right, left});
        return grid[i][j]+max(max(up,down),max(right,left));
    }

    int getMaximumGold(vector<vector<int>>& grid) 
    {
        int maxGold=0;
        n=grid.size();
        m=grid[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0)
                {
                    maxGold=max(maxGold,solve(grid,i,j));
                }
            }
        }
        return maxGold;
    }
};