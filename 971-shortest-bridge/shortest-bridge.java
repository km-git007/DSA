class Solution {
    // Direction array to represent the 4 directions
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int n, m;
    private void dfs(int row, int col, int[][] grid, Queue<int[]> q)
    {
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] != 1)
        return;

        // Mark the first island cell as -1
        grid[row][col] = -1;

        // push in the queue
        q.add(new int[]{row, col, 0});


        for(int[] dir : directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(r, c, grid, q);
        }
    }

    int bfs(int[][] grid, Queue<int[]> q)
    {
        while(!q.isEmpty())
        {
            int[] arr = q.poll();
            int row = arr[0];
            int col = arr[1];
            int dist = arr[2];

            for(int[] dir : directions)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] >= 0)
                {
                    // Found the first island
                    if(grid[r][c] == 1)
                    return dist;

                    // mark the cell as vis
                    grid[r][c] = -1;

                    // push in the queue
                    q.add(new int[]{r, c, dist + 1});
                }
            }
        }
        // whatever the fuck you want
        return -1;
    }

    public int shortestBridge(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // call the dfs from any one island cell
        boolean found = false;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            if(grid[i][j] == 1)
            {
                dfs(i, j, grid, q);
                found = true;
                break;
            }
            if(found)
            break;
        }

        // Perform BFS to find the shortest bridge
        return bfs(grid, q);
    }
}