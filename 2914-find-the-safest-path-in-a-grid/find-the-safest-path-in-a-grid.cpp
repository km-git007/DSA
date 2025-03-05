class Solution {
public:
    int n;
    vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    vector<vector<int>> manHattenDistance(vector<vector<int>>& grid)
    {
        //can be used as vis vector
        vector<vector<int>> dist(n, vector<int>(n, -1));
        queue<pair<int, pair<int, int>>> q;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.push({0, {i, j}});
                    dist[i][j] = 0; // Thief cells have 0 distance
                }
            }
        }

        while(!q.empty())
        {
            auto [distance, cell] = q.front();
            q.pop();
            int row = cell.first, col = cell.second;

            for(auto [dx, dy] : directions)
            {
                int r = row + dx;
                int c = col + dy;
                if(isValidCell(r, c) && dist[r][c] == -1 && grid[r][c] == 0)
                {
                    q.push({distance + 1, {r, c}});
                    dist[r][c] = distance + 1;
                }
            }
        }
        return dist;
    }

    int bfs(vector<vector<int>>& grid, vector<vector<int>>& dist)
    {
        // vis vector
        vector<vector<int>> vis(n, vector<int>(n,0));
    
        // Priority queue to process maximum safeness first
        // {safeness, row, col}
        priority_queue<vector<int>> pq;
        pq.push({dist[0][0], 0, 0}); 
    
        // BFS traversal
        while (!pq.empty()) 
        {
            auto curr = pq.top();
            pq.pop();
            int currSafeness = curr[0];
            int row = curr[1];
            int col = curr[2];
        
            // If we reach the destination, return the distance
            if (row == n - 1 && col == n - 1)
            return currSafeness;

            if(vis[row][col])
            continue;

            vis[row][col] = 1;
        
            // Explore all possible directions
            for (auto [dx, dy] : directions) 
            {
                int newRow = row + dx;
                int newCol = col + dy;

                // Check if the new cell is within bounds
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !vis[newRow][newCol]) 
                {
                    int newSafeness = min(currSafeness, dist[newRow][newCol]);
                    pq.push({newSafeness, newRow, newCol});
                }
            }
        }
        // return whatever the fuck you want to
        return -1;
    }

    int maximumSafenessFactor(vector<vector<int>>& grid) 
    {
        n = grid.size();
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
        return 0;

        auto dist = manHattenDistance(grid);
        return bfs(grid, dist);
    }

private:
    bool isValidCell(int r, int c)
    {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
};
