class Solution {
private:
    const vector<vector<int>> DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n, m, id;

    int dfs(vector<vector<int>>& grid, int row, int col, int id) {
        if (!isValidCell(row, col) || grid[row][col] != 1)
            return 0;
        
        // Mark the cell with a unique id
        grid[row][col] = id;
        int count = 1; // Count the current land cell
        
        // Explore all 4 directions
        for (const auto& dir : DIRECTIONS) {
            count += dfs(grid, row + dir[0], col + dir[1], id);
        }
        
        return count;
    }

    bool isValidCell(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

public:
    int largestIsland(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();
        id = 2;
        
        unordered_map<int, int> map; // {id -> size}
        map[0] = 0; // Handle empty water cases
        
        int largestIsland = 0;
        
        // Assign unique IDs to islands and compute sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j, id);
                    largestIsland = max(largestIsland, islandSize);
                    map[id] = islandSize;
                    id++;
                }
            }
        }

        // Try flipping each 0 and merging islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int islandSize = 1; // Flipping 0 to 1
                    unordered_set<int> uniqueIslands;
                    
                    for (const auto& dir : DIRECTIONS) {
                        int row = i + dir[0];
                        int col = j + dir[1];

                        if (isValidCell(row, col)) {
                            uniqueIslands.insert(grid[row][col]);
                        }
                    }

                    for (int islandId : uniqueIslands) {
                        islandSize += map[islandId];
                    }

                    largestIsland = max(largestIsland, islandSize);
                }
            }
        }
        
        return largestIsland;
    }
};
