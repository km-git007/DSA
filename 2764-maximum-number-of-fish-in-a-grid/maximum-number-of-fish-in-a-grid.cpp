class Solution {
public:
    int n, m;
    vector<vector<int>> vis;
    vector<vector<int>> directions = {{-1,0},{0,-1},{0,1},{1,0}};
    int dfs(int row, int col, vector<vector<int>>& grid)
    {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0 || vis[row][col])
        return 0;

        vis[row][col] = 1;

        int fish = grid[row][col];
        for(auto dir : directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            fish += dfs(r, c, grid);
        }

        return fish;
    }
    
    int findMaxFish(vector<vector<int>>& grid) 
    {
        n = grid.size();
        m = grid[0].size();
        vis = vector<vector<int>> (n, vector<int>(m, 0));

        int maxFish=0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] && !vis[i][j])
                maxFish = max(maxFish, dfs(i, j, grid));
            }
        }
        return maxFish;
    }
};