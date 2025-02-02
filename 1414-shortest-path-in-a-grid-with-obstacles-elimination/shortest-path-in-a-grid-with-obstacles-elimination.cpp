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
    
        // {k, row, col}
        queue<vector<int>> q;
        q.push({k, 0, 0}); 
    
        // BFS traversal
        int steps = 0;
        while (!q.empty()) 
        {
            int level = q.size();
            for(int l = 0; l < level; l++)
            {
                auto curr = q.front();
                q.pop();
                int moves = curr[0];
                int row = curr[1];
                int col = curr[2];
            
                // If we reach the destination, return the distance
                if (row == n - 1 && col == m - 1)
                return steps;

                // if the curr cell is visited we already have got the shortest dist to reach this cell
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
                        // If a smaller dist is found, update and push to the queue
                        if (moves - wt >= 0) 
                        q.push({moves - wt, newRow, newCol});
                    }
                }
            }
            steps++;
        }
        // return -1 if can't reach
        return -1;
    }
};