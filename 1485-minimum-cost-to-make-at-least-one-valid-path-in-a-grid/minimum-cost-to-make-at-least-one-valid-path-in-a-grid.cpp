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

        // create cost array
        vector<vector<int>> cost(n, vector<int>(m, 1e9));
        // cost to reach source is '0'
        cost[0][0] = 0;

        // Min-Heap of vectors (lexicographical order) {cost, row, col}
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        pq.push({0, 0, 0});

        while(!pq.empty())
        {
            auto v = pq.top();
            pq.pop();

            int currCost = v[0];
            int row = v[1];
            int col = v[2];

            if(row == n - 1 && col == m - 1)
            return currCost;

            for(int i = 0; i < directions.size(); i++)
            {
                int r = row + directions[i].first;
                int c = col + directions[i].second;
                if(r >= 0 && r < n && c >= 0 && c < m)
                {
                    int nextCellTravelCost = ((grid[row][col] - 1) == i ? 0 : 1);
                    if(cost[r][c] > nextCellTravelCost + currCost)
                    {
                        cost[r][c] = nextCellTravelCost + currCost;
                        pq.push({cost[r][c], r, c});
                    }
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