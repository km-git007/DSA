class Solution {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] grid) 
    {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) 
        {
            int[] node = pq.poll();
            int r = node[1], c = node[2], currEffort = node[0];

            if(r == rows - 1 && c == cols - 1)
            return currEffort;

            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] dir : directions) 
            {
                int newRow = r + dir[0], newCol = c + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) 
                {
                    int newEffort = Math.max(currEffort, Math.abs(grid[newRow][newCol] - grid[r][c]));
                    pq.offer(new int[]{newEffort, newRow, newCol});
                }
            }
        }
        return 0;
    }
}