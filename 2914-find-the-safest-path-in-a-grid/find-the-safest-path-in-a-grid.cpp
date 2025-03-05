class Solution {
public:
    int n;
    int maxManHattenDist = -1;
    int directions[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    vector<vector<int>> manHattenDistance(vector<vector<int>>& grid)
    {
        vector<vector<int>> dist(n, vector<int>(n, 0));
        queue<pair<int, pair<int, int>>> q;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                    q.push({0, {i, j}});
                else
                    dist[i][j] = -1;
            }
        }

        while(!q.empty())
        {
            auto [distance, cell] = q.front();
            q.pop();
            int row = cell.first, col = cell.second;

            maxManHattenDist = max(maxManHattenDist, dist[row][col]);

            for(auto dir : directions)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                if(isValidCell(r, c) && dist[r][c] == -1 && grid[r][c] == 0)
                {
                    q.push({distance + 1, {r, c}});
                    dist[r][c] = distance + 1;
                }
            }
        }
        return dist;
    }

    bool bfs(int sf, vector<vector<int>>& grid, vector<vector<int>>& dist)
    {
        if(dist[0][0] < sf)
            return false;

        queue<pair<int, int>> q;
        q.push({0, 0});

        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[0][0] = true;

        while(!q.empty())
        {
            auto [row, col] = q.front();
            q.pop();

            if(row == n - 1 && col == n - 1)
                return true;

            for(auto dir : directions)
            {
                int r = row + dir[0];
                int c = col + dir[1];

                if(isValidCell(r, c) && !visited[r][c] && dist[r][c] >= sf)
                {
                    q.push({r, c});
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }

    int solve(vector<vector<int>>& grid, vector<vector<int>>& dist)
    {
        int start = 1, end = maxManHattenDist, res = 0;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(bfs(mid, grid, dist))
            {
                res = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return res;
    }

    int maximumSafenessFactor(vector<vector<int>>& grid) 
    {
        n = grid.size();
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return 0;

        auto dist = manHattenDistance(grid);
        return solve(grid, dist);
    }

private:
    bool isValidCell(int r, int c)
    {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
};
