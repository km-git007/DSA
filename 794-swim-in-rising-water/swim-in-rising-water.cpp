class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        
        // Directions for up, down, left, right movement
        vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        // to optimise dijkstras
        vector<vector<int>> vis(n, vector<int>(n, 0));
    
        // Priority queue to process the smallest dist first
        // {dist, row, col}
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        pq.push({grid[0][0], 0, 0}); 
    
        while (!pq.empty()) 
        {
            auto curr = pq.top();
            pq.pop();
            int currTime = curr[0];
            int row = curr[1];
            int col = curr[2];
        
            // If we reach the destination, return the distance
            if (row == n - 1 && col == n - 1)
            return currTime;

            // if the current cell is visited we already have got the shortest time to reach this cell
            if(vis[row][col])
            continue;

            // mark the cell as visited 
            vis[row][col] = 1;
        
            // Explore all possible directions
            for (auto [dx, dy] : directions) 
            {
                int newRow = row + dx;
                int newCol = col + dy;

                // Check if the new cell is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) 
                pq.push({max(currTime, grid[newRow][newCol]), newRow, newCol});
            }
        }
        // return whatever the fuck you want to
        return -1;
    }
};