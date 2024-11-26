class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) 
    {
        int n = heights.size();
        int m = heights[0].size();
        
        // Directions for up, down, left, right movement
        vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    
        // Distance vector to store minimum effort for each cell
        vector<vector<int>> effort(n, vector<int>(m, INT_MAX));
        effort[0][0] = 0; // Starting point distance is 0
    
        // Priority queue to process the smallest effort first
        // {effort, row, col}
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0}); 
    
        // BFS traversal
        while (!pq.empty()) 
        {
            auto curr = pq.top();
            pq.pop();
            int currEffort = curr[0];
            int row = curr[1];
            int col = curr[2];
        
            // If we reach the destination, return the distance
            if (row == n - 1 && col == m - 1)
            return effort[row][col];
        
            // Explore all possible directions
            for (auto [dx, dy] : directions) 
            {
                int newRow = row + dx;
                int newCol = col + dy;

                // Check if the new cell is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) 
                {
                    // Calculate the effort to move to the new cell
                    int newEffort = max(currEffort, abs(heights[row][col] - heights[newRow][newCol]));
                    // If a smaller effort is found, update and push to the priority queue
                    if (newEffort < effort[newRow][newCol]) 
                    {
                        effort[newRow][newCol] = newEffort;
                        pq.push({newEffort, newRow, newCol});
                    }
                }
            }
        }
        // return whatever the fuck you want to
        return -1;
    }
};