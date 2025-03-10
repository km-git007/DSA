class Solution {
public:
    vector<pair<int, int>> directions = {
        {0, 1},   // Right 
        {0, -1}, // Left 
        {1, 0},  // Down 
        {-1, 0} // Up 
    };

    int solve(vector<vector<int>>& grid)
    {
        int n = grid.size();
        int m = grid[0].size();

        // create vis array
        vector<vector<bool>> vis(n, vector<bool>(m, false));

        // deque {cost, row, col}
        deque<vector<int>> dq;
        dq.push_front({0, 0, 0});
        // vis[0][0] = true;

        // '0 - 1' BFS
        while(!dq.empty())
        {
            auto v = dq.front();
            dq.pop_front();

            int cost = v[0];
            int row = v[1];
            int col = v[2];

            if(row == n - 1 && col == m - 1)
            return cost;

            if(vis[row][col])  // ✅ Skip already visited nodes
            continue;

            vis[row][col] = true;  // ✅ Mark as visited after dequeuing

            for(int i = 0; i < directions.size(); i++)
            {
                int r = row + directions[i].first;
                int c = col + directions[i].second;
                if(r >= 0 && r < n && c >= 0 && c < m && !vis[r][c])
                {
                    int nextCellTravelCost = ((grid[row][col] - 1) == i ? 0 : 1);

                    if(nextCellTravelCost == 0)
                    dq.push_front({cost, r, c});

                    else
                    dq.push_back({cost + 1, r, c});

                    // vis[row][col] = true;
                }
            }
        }
        return - 1;
    }

    int minCost(vector<vector<int>>& grid) 
    {
        return solve(grid);
    }
};