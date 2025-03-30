class Solution {
public:
    int M, N;
    // The three possible directions for the next column.
    const int dirs[3] = {-1, 0, 1};
    bool isValidCell(int row, int col)
    {
        return row >= 0 && col >= 0 && row < M && col < N;
    }
    int maxMoves(vector<vector<int>>& grid) 
    {
        M = grid.size();
        N = grid[0].size();

        queue<pair<int, int>> q;
        vector<vector<int>> vis(M, vector<int>(N, 0));
        // Enqueue the cells in the first column.
        for (int i = 0; i < M; i++) 
        {
            vis[i][0] = 1;
            q.push({i, 0});
        }

        int moves = 0;
        while(!q.empty()) 
        {
            int sz = q.size();
            while(sz--) 
            {
                auto [row, col] = q.front();
                q.pop();

                for (int dir : dirs) 
                {
                    // Next cell after the move.
                    int newRow = row + dir, newCol = col + 1;

                    // If the next cell isn't visited yet and is greater than
                    // the current cell value. Add it to the queue with the
                    // moves required.
                    if(isValidCell(newRow, newCol) && !vis[newRow][newCol] && grid[row][col] < grid[newRow][newCol]) 
                    {
                        vis[newRow][newCol] = 1;
                        q.push({newRow, newCol});
                    }
                }
            }
            moves++;
        }
        return moves - 1;
    }
};