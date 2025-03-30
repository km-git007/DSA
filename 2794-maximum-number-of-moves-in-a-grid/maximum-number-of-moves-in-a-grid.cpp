class Solution {
public:
    int M, N;
    // The three possible directions for the next column.
    const int direction[3] = {-1, 0, 1};
    vector<vector<int>> dp;
    int DFS(int row, int col, vector<vector<int>>& grid) 
    {
        if(dp[row][col] != -1)
        return dp[row][col];

        int maxMoves = 0;
        for (int dir : direction) 
        {
            // Next cell after the move.
            int newRow = row + dir, newCol = col + 1;

            // If the next cell is valid and greater than the current cell
            // value, perform recursion to that cell with updated value of moves.
            if(newRow >= 0 && newCol >= 0 && newRow < M && newCol < N && grid[row][col] < grid[newRow][newCol])
            maxMoves = max(maxMoves, 1 + DFS(newRow, newCol, grid));
        }

        return dp[row][col] = maxMoves;
    }

    int maxMoves(vector<vector<int>>& grid) 
    {
        M = grid.size();
        N = grid[0].size();
        dp = vector<vector<int>>(M, vector<int>(N, -1));

        int maxMoves = 0;
        for(int i = 0; i < M; i++) 
        {
            int movesRequired = DFS(i, 0, grid);
            maxMoves = max(maxMoves, movesRequired);
        }
        return maxMoves;
    }
};