class Solution {
public:
    bool findSafeWalk(vector<vector<int>>& grid, int health) 
    {
        int n = grid.size();
        int m = grid[0].size();
        
        // Directions for up, down, left, right movement
        vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    
        vector<vector<int>> vis(n, vector<int>(m, 0));
        // Mark start as visited
        vis[0][0] = 1; 
    
        // deque {healthLoss, row, col}
        deque<vector<int>> dq;
        dq.push_front({grid[0][0], 0, 0}); 
    
        // BFS traversal
        while (!dq.empty()) 
        {
            auto curr = dq.front();
            dq.pop_front();
            int healthLoss = curr[0];
            int row = curr[1];
            int col = curr[2];
        
            // If we reach the destination, return true
            if (row == n - 1 && col == m - 1)
            return true;
        
            // Explore all possible directions
            for (auto [dx, dy] : directions) 
            {
                int newRow = row + dx;
                int newCol = col + dy;

                // Check if the new cell is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol]) 
                {
                    int wt = grid[newRow][newCol];
                    if(health - healthLoss - wt > 0)
                    {
                        // health will get down in this cell
                        if(wt == 1)
                        dq.push_back({healthLoss + wt, newRow, newCol});

                        // health safe cell
                        else 
                        dq.push_front({healthLoss + wt, newRow, newCol});
                    }

                    // mark the cell as visited 
                    vis[newRow][newCol] = 1;
                }
            }
        }
        
        // return false
        return false;
    }
};