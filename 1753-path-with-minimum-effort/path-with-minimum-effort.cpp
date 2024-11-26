class Solution {
public:
    bool canReach(vector<vector<int>>& heights, int k)
    {
        int n = heights.size();
        int m = heights[0].size();
        // Directions for up, down, left, right movement
        vector<pair<int, int>> directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    
        // BFS to check reachability
        queue<pair<int, int>> q;
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        q.push({0, 0});
        visited[0][0] = true;
    
        // BFS traversal
        while (!q.empty()) 
        {
            auto [row, col] = q.front();
            q.pop();
        
            // If we reach the destination, return true
            if (row == n - 1 && col == m - 1)
            return true;
        
            // Explore neighbors
            for (auto [dx, dy] : directions) 
            {
                int newRow = row + dx;
                int newCol = col + dy;

                // Check bounds and if not visited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) 
                {
                    int diff = abs(heights[row][col] - heights[newRow][newCol]);
                    // Only traverse if edge cost <= k
                    if (diff <= k) 
                    {  
                        visited[newRow][newCol] = true;
                        q.push({newRow, newCol});
                    }
                }
            }
        }
        // Destination not reachable
        return false;  
    }

    int minimumEffortPath(vector<vector<int>>& heights) 
    {
        int n = heights.size();
        int m = heights[0].size();

        // Binary search range for k
        int low = 0, high = 1e6; // Assume heights differences are bounded
        int result = high;

        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            if (canReach(heights, mid)) 
            {
                result = mid;  // Update result
                high = mid - 1;  // Try smaller k
            } 
            else 
            {
                // Try larger k
                low = mid + 1;  
            }
        }
        return result;
    }
};