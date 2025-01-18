class Solution {
public:
    int n, m;
    bool dfs(int row, int col, vector<vector<int>>& grid)
    {
        if(row >= n || col >= m || !grid[row][col])
        return false;

        if(row == n - 1 && col == m - 1)
        return true;

        // marking the current cell as visited
        grid[row][col] = 0;

        return dfs(row, col + 1, grid) || dfs(row +1, col, grid);
    }

    bool isPossibleToCutPath(vector<vector<int>>& grid) 
    {
        n = grid.size();
        m = grid[0].size();

        // we can't even reach the last cell already then no need of flip
        // this dfs will mark one of the path taken from src to dest as '0's
        if(!dfs(0, 0, grid))
        return true;

        // mark the src cell as unvisited.
        grid[0][0] = 1;

        if(dfs(0, 0, grid))
        return false;

        return true;
    }
};