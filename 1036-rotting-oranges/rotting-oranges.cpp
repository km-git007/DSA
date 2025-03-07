class Solution {
public:
    pair<int, int> directions[4] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int orangesRotting(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        int m = grid[0].size();
        int freshCount = 0;
        queue<pair<int,int>> q;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2)
                q.push({i, j});

                if(grid[i][j] == 1)
                freshCount++;
            }
        }

        int time = 0;
        while(!q.empty())
        {
            int levelSize = q.size();
            bool isRotten = false;
            while(levelSize--)
            {
                int row = q.front().first;
                int col = q.front().second;
                q.pop();
                for(auto [dx, dy] : directions)
                {
                    int nRow = row + dx;
                    int nCol = col + dy;
                    if(nRow >= 0 and nRow < n and nCol >= 0 and nCol < m and grid[nRow][nCol] == 1)
                    {
                        q.push({nRow, nCol});
                        grid[nRow][nCol] = 2;
                        freshCount--;
                        isRotten = true;
                    }  
                }
            }
            if(isRotten)
            time++;
        }
        return(freshCount == 0) ? time : -1;
    }
};