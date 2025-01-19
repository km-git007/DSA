class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        int m = grid[0].size();
        
        // Directions for up, down, left, right movement
        vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    
        // Distance vector to store minimum dist for each cell
        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));
        dist[0][0] = 0; // Starting point distance is 0

        vector<vector<int>> vis(n, vector<int>(m, 0));
    
        // Priority queue to process the smallest dist first
        // {dist, row, col}
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0}); 
    
        // BFS traversal
        while (!pq.empty()) 
        {
            auto curr = pq.top();
            pq.pop();
            int currDist = curr[0];
            int row = curr[1];
            int col = curr[2];
        
            // If we reach the destination, return the distance
            if (row == n - 1 && col == m - 1)
            return dist[row][col];

            // if the current cell is visited we already have got the shortest distance to reach this cell
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
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) 
                {
                    int wt = grid[newRow][newCol] == 1 ? 1 : 0;
                    // If a smaller dist is found, update and push to the priority queue
                    if (wt + currDist < dist[newRow][newCol]) 
                    {
                        dist[newRow][newCol] = wt + currDist;
                        pq.push({dist[newRow][newCol], newRow, newCol});
                    }
                }
            }
        }
        // return whatever the fuck you want to
        return -1;
    }
};