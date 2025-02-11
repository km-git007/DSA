class Solution {
public:
    int n, m;
    vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    void dfs(int row, int col, vector<vector<int>>& grid, queue<pair<int,int>> &q)
    {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1)
        return;

        //mark the cell
        grid[row][col] = -1;

        // add to the queue
        q.push({row, col});

        for(auto [dx, dy] : directions)
        {
            int r = row + dx;
            int c = col + dy;
            dfs(r, c, grid, q);
        }
    }

    int bfs(vector<vector<int>>& grid, queue<pair<int,int>> &q)
    {
        int dist = 0;
        while(!q.empty())
        {
            int levelSize = q.size();
            while(levelSize--)
            {
                auto [row, col] = q.front();
                q.pop();

                for(auto [dx, dy] : directions)
                {
                    int r = row + dx;
                    int c = col + dy;
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] >= 0)
                    {
                        if(grid[r][c] == 1)
                        return dist;

                        q.push({r, c});
                        grid[r][c] = -1;
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    int shortestBridge(vector<vector<int>>& grid) 
    {
        n = grid.size();
        m = grid[0].size();

        queue<pair<int,int>> q;
        
        // Step 1: Find and mark the first island using DFS
        bool found = false;
        for (int i = 0; i < n && !found; i++) 
        {
            for (int j = 0; j < m && !found; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    dfs(i, j, grid, q);
                    found = true;  // Stop after marking one island
                }
            }
        }

        return bfs(grid, q);
    }
};