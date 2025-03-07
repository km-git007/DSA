class Solution {
public:
    int n, m;
    vector<vector<int>> vis;
    pair<int, int> directions[4] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    bool canReach(int waitTime, vector<vector<int>>& grid, vector<vector<int>>& fireTime)
    {
        queue<pair<int, int>> q;
        q.push({0, 0});

        // Reset visitation matrix
        vis.assign(n, vector<int>(m, 0)); 
        vis[0][0] = 1;

        int time = waitTime;
        while (!q.empty()) 
        {
            int levelSize = q.size();
            while(levelSize--)
            {
                auto [row, col] = q.front();
                q.pop();

                for (auto [dx, dy] : directions) 
                {
                    int nRow = row + dx;
                    int nCol = col + dy;

                    if(isValidCell(nRow, nCol) && grid[nRow][nCol] == 0 && !vis[nRow][nCol]) 
                    {
                        if(nRow == n - 1 && nCol == m - 1)
                        {
                            // if(fireTime[n - 1][m - 1] == 1e9) // Fire never reaches exit
                            // return true;

                            return time + 1 <= fireTime[nRow][nCol];
                        }

                        if(time + 1 < fireTime[nRow][nCol]) 
                        {
                            vis[nRow][nCol] = 1;
                            q.push({nRow, nCol});
                        }
                    }
                }
            }
            time++;
        }
        return false;
    }

    vector<vector<int>> fireSpread(vector<vector<int>>& grid) 
    {
        // 1e9 means fire never reaches
        vector<vector<int>> fireTime(n, vector<int>(m, 1e9)); 

        queue<pair<int, int>> q;
        // Multi-source BFS: Add all fire positions (1) to the queue
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    q.push({i, j});
                    fireTime[i][j] = 0; // Fire starts here
                }
            }
        }

        // BFS
        while (!q.empty()) 
        {
            auto [row, col] = q.front();
            q.pop();

            for (auto [dx, dy] : directions) 
            {
                int nRow = row + dx;
                int nCol = col + dy;

                if (isValidCell(nRow, nCol) && grid[nRow][nCol] == 0 && fireTime[nRow][nCol] == 1e9) 
                {
                    fireTime[nRow][nCol] = fireTime[row][col] + 1;
                    q.push({nRow, nCol});
                }
            }
        }

        return fireTime;
    }

    int maximumMinutes(vector<vector<int>>& grid) 
    {
        n = grid.size();
        m = grid[0].size();

        // build the 2D time array 
        auto fireTime = fireSpread(grid);

        int start = 0;
        int end = 1e9;
        int minStayTime = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(canReach(mid, grid, fireTime))
            {
                minStayTime = mid;
                start = mid + 1;
            }

            else
            end = mid - 1;
        }

        // If fire never reaches exit, return max possible time
        if(minStayTime != -1 && fireTime[n-1][m-1] == 1e9)
        return 1e9;

        return minStayTime;
    }

    bool isValidCell(int row, int col)
    {
       return row >= 0 && row < n && col >= 0 && col < m;
    }
};