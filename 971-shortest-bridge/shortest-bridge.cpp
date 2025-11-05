class Solution {
private:
    int n, m;
    vector<pair<int,int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
public:
    void dfs(int row, int col, vector<vector<int>>& grid, vector<vector<bool>>& vis, queue<pair<int,int>>& queue){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] != 1 || vis[row][col]){
            return;
        }

        vis[row][col] = true;
        queue.push({row, col});

        for(auto dir : directions){
            int newRow = row + dir.first;
            int newCol = col + dir.second;
            dfs(newRow, newCol, grid, vis, queue);
        }
    }

    int shortestBridge(vector<vector<int>>& grid) {

        n = grid.size();
        m = grid[0].size();

        bool canExit = false;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        queue<pair<int,int>> queue;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    canExit = true;
                    dfs(i, j, grid, vis, queue);
                    break;
                }
            }
            if(canExit){
                break;
            }
        }

        int steps = 0;
        while(!queue.empty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                auto curr = queue.front();
                queue.pop();
                int row = curr.first;
                int col = curr.second;

                for(auto dir : directions){
                    int newRow = row + dir.first;
                    int newCol = col + dir.second;
                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m || vis[newRow][newCol]){
                        continue;
                    }

                    if(grid[newRow][newCol] == 1){
                        return steps;
                    }

                    queue.push({newRow, newCol});
                    vis[newRow][newCol] = true;
                }
            }
            steps++;
        }
        return -1;
    }
};