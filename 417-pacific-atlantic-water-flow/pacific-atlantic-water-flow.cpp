class Solution {
public:
    int n, m;
    vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    void bfs(queue<pair<int, int>>& q, vector<vector<bool>>& vis, vector<vector<int>>& grid) 
    {
        while (!q.empty()) 
        {
            auto [row, col] = q.front();
            q.pop();
        
            for (auto dir : directions) 
            {
                int newRow = row + dir.first;
                int newCol = col + dir.second;

                // Check boundaries and if already visited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && 
                !vis[newRow][newCol] && grid[row][col] <= grid[newRow][newCol]) 
                {
                    vis[newRow][newCol] = true;
                    q.push({newRow, newCol});
                }
            }
        }
    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& grid) 
    {
        n = grid.size();
        m = grid[0].size();

        queue<pair<int, int>> pacific, atlantic;
        vector<vector<bool>> pacificVis, atlanticVis;
        atlanticVis = pacificVis = vector<vector<bool>>(n, vector<bool>(m, false));
        // start bfs from the shore of pacific and atlantic
        for(int i = 0; i < m; i++)
        {
            pacific.push({0, i});
            atlantic.push({n - 1, i});
            pacificVis[0][i] = true;
            atlanticVis[n - 1][i] = true;
        }

        for(int i = 0; i < n; i++)
        {
            pacific.push({i, 0});
            atlantic.push({i, m - 1});
            pacificVis[i][0] = true;
            atlanticVis[i][m - 1] = true;
        }

        // start bfs from the shore of atlantic and pacific
        bfs(pacific, pacificVis, grid);
        bfs(atlantic, atlanticVis, grid);

        vector<vector<int>> res;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(pacificVis[i][j] && atlanticVis[i][j])
                res.push_back({i, j});
            }
        }
        return res;
    }
};