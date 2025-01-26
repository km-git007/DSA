class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) 
    {
        int n = grid.size();
        int m = grid[0].size();
        
        // Directions for up, down, left, right movement
        vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    
        // vis{row,col, k}
        vector<vector<vector<int>>> vis(n, vector<vector<int>>(m, vector<int>(k + 1, 0)));
    
        // Priority queue to process the smallest dist first
        // {dist, k, row, col}
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        pq.push({0, k, 0, 0}); 
    
        // BFS traversal
        while (!pq.empty()) 
        {
            auto curr = pq.top();
            pq.pop();
            int currDist = curr[0];
            int moves = curr[1];
            int row = curr[2];
            int col = curr[3];
        
            // If we reach the destination, return the distance
            if (row == n - 1 && col == m - 1)
            return currDist;

            // if the current cell is visited we already have got the shortest distance to reach this cell
            if(vis[row][col][moves])
            continue;

            // mark the cell as visited 
            vis[row][col][moves] = 1;
        
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
                    if (moves - wt >= 0) 
                    pq.push({1 + currDist, moves - wt, newRow, newCol});
                }
            }
        }
        // return -1 if can't reach
        return -1;
    }
};