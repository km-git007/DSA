class Solution {
public:
    int n;
    vector<pair<int, int>> directions = {
        {-1, 0}, // Up
        {0, 1},  // Right
        {1, 0},  // Down
        {0, -1}  // Left
    };

    int dfs(int row, int col, vector<vector<int>>& grid, int &id)
    {
        if(row < 0 || row >= n || col < 0 || col >= n || !grid[row][col] || grid[row][col] == id)
        return 0;

        // mark the curr cell as visited
        grid[row][col] = id;

        int size = 1;
        for (auto [dx, dy] : directions) 
        {
            int r = row + dx;
            int c = col + dy;

            size += dfs(r, c, grid, id);
        }
        return size;
    }

    int largestIsland(vector<vector<int>>& grid) 
    {
        n = grid.size();
        unordered_map<int, int> map;

        int id = 2;
        // Mark each island with a unique ID and calculate its size
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    int islandSize = dfs(i, j, grid, id);
                    map[id] = islandSize;
                    id++;
                }
            }
        }

        // there's no land, only water exists 
        // flip any zero and get island of 1 unit
        if (map.empty()) 
        return 1;

        int maxSize = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                {
                    int largeIslandSize = 1;
                    unordered_set<int> set;
                    for (auto [r, c] : directions) 
                    {
                        int row = i + r;
                        int col = j + c;

                        if(row < 0 || row >= n || col < 0 || col >= n || grid[row][col] < 2)
                        continue;

                        int neighborId = grid[row][col];
                        if(!set.count(neighborId)) 
                        {
                            largeIslandSize += map[neighborId];
                            set.insert(neighborId);
                        }

                    }
                    maxSize = max(maxSize, largeIslandSize);
                }
            }
        }
        return maxSize == 0 ? n * n : maxSize;
    }
};