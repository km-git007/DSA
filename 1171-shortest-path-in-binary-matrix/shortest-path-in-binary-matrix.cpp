class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) 
    {
        int n = grid.size();
    
    // Directions for up, down, left, right, and diagonal movements
    vector<pair<int, int>> directions = {
        {0, -1}, {1, 0}, {0, 1}, {-1, 0},  // Left, Down, Right, Up
        {-1, -1}, {1, 1}, {1, -1}, {-1, 1} // Diagonals: top-left, bottom-right, bottom-left, top-right
    };
    
    // Create a visited vector to track visited cells
    vector<vector<bool>> visited(n, vector<bool>(n, false));
    
    // If the source or destination is blocked, return -1 immediately
    if (grid[0][0] != 0 || grid[n-1][n-1] != 0) 
    return -1;
    

    // Queue for BFS, storing {row, col}
    queue<pair<int, int>> q;
    q.push({0, 0});
    visited[0][0] = true; // Mark the source as visited
    
    // BFS traversal
    int distance = 0;
    while (!q.empty()) 
    {
        int levelSize = q.size();
        for (int i = 0; i < levelSize; i++) 
        {
            auto [row, col] = q.front();
            q.pop();

            // If we reach the destination, return the distance
            if(row == n - 1 && col == n - 1) 
            return distance + 1;
            

            // Explore the 8 possible directions (up, down, left, right, diagonals)
            for(auto [dx, dy] : directions)
            {
                int newRow = row + dx;
                int newCol = col + dy;
                
                // Check if the new cell is within bounds, not visited, and has a value of 0
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 0) 
                {
                    visited[newRow][newCol] = true;  // Mark as visited
                    q.push({newRow, newCol});  // Add to queue for further exploration
                }
            }
        }
        distance++;  // Increment the distance after processing one level
    }
    
    // If no path is found to the destination
    return -1;
    }
};