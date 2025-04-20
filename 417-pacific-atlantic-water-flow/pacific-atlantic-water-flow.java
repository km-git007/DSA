class Solution {
    int n, m;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
    public void bfs(int[][] heights, int[][] vis, Queue<int[]> q) 
    {
        while (!q.isEmpty()) 
        {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : dirs) 
            {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || vis[nx][ny] == 1 || heights[nx][ny] < heights[x][y]) 
                continue;

                vis[nx][ny] = 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        m = heights.length;
        n = heights[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        for (int i = 0; i < m; i++) 
        {
            pacific[i][0] = 1;
            pq.offer(new int[]{i, 0});
            
            atlantic[i][n - 1] = 1;
            aq.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) 
        {
            pacific[0][j] = 1;
            pq.offer(new int[]{0, j});

            atlantic[m - 1][j] = 1;
            aq.offer(new int[]{m - 1, j});
        }

        bfs(heights, pacific, pq);
        bfs(heights, atlantic, aq);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1)
                res.add(List.of(i, j));
            }
        }
        return res;
    }
}