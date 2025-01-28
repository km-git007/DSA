class Solution {
public:
    // directions
    int maxManHattenDist = -1;
    int directions[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int n;
    vector<vector<int>> manHattenDistance(vector<vector<int>>& grid)
    {
        // create manhatten distance vector
        vector<vector<int>> dist(n, vector<int>(n, 0));

        vector<vector<bool>> visited(n, vector<bool>(n, false));

        queue<vector<int>> q;
        // Start BFS from all thief cells
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                q.push({i, j, 0});
            }
        }

        while(!q.empty())
        {
            auto v = q.front();
            q.pop();

            int row = v[0], col = v[1], distance = v[2];

            // Update maximum Manhattan distance
            maxManHattenDist = max(maxManHattenDist, dist[row][col]);

            for(auto dir : directions)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && grid[r][c] == 0)
                {
                    q.push({r, c, distance + 1});
                    dist[r][c] = distance + 1;
                    visited[r][c] = true;
                }
            }
        }
        // return the manhatten distance vector
        return dist;
    }

    bool isPathValid(int sf, vector<vector<int>>& dist)
    {
        if(dist[0][0] < sf)
        return false;
        
        // BFS to check if a valid path exists with the given safeness factor
        queue<pair<int, int>> q;
        q.push({0, 0});

        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[0][0] = true;

        while (!q.empty()) 
        {
            auto [row, col] = q.front();
            q.pop();

            // If we reach the bottom-right corner
            if(row == n - 1 && col == n - 1)
            return true;

            for (auto dir : directions) 
            {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && dist[r][c] >= sf) 
                {
                    visited[r][c] = true;
                    q.push({r, c});
                }
            }
        }

        return false;
    }

    int solve(vector<vector<int>>& grid, vector<vector<int>>& dist)
    {
        int start = 1;
        int end = maxManHattenDist;

        int res = 0;
        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(isPathValid(mid, dist))
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

        // return 0 if any of start, end cell has a theif
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
        return 0;

        // build the manhatten distance vector
        auto dist = manHattenDistance(grid);

        // Solve for the maximum safeness factor
        return solve(grid, dist);
    }
};