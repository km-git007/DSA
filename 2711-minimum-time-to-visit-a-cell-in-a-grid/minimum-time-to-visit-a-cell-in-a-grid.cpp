class Solution {
public:
    vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int solve(vector<vector<int>>& grid)
    {
        int n = grid.size();
        int m = grid[0].size();

        // create time array
        // vector<vector<int>> time(n, vector<int>(m, 1e9));
        // time to reach source is '0'
        // time[0][0] = 0;

        vector<vector<int>> vis(n, vector<int>(m, 0));
        // Min-Heap of vectors (lexicographical order) {time, row, col}
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        pq.push({0, 0, 0});

        while(!pq.empty())
        {
            auto v = pq.top();
            pq.pop();

            int currTime = v[0];
            int row = v[1];
            int col = v[2];

            if(row == n - 1 && col == m - 1)
            return currTime;

            if(vis[row][col])
            continue;

            for(int i = 0; i < directions.size(); i++)
            {
                int r = row + directions[i].first;
                int c = col + directions[i].second;

                if(r < 0 || r >= n || c < 0 || c >= m)
                continue;

                if(currTime + 1 >= grid[r][c])
                pq.push({currTime + 1, r, c});

                else
                {
                    int diff = grid[r][c] - currTime;

                    if(diff % 2 == 0)
                    pq.push({grid[r][c] + 1, r, c});

                    else
                    pq.push({grid[r][c], r, c});
                }
            }

            vis[row][col] = 1;
        }
        return - 1;
    }

    int minimumTime(vector<vector<int>>& grid) 
    {
        if(grid[0][1] > 1 && grid[1][0] > 1)
        return -1;

        return solve(grid);
    }
};