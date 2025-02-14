class Solution {
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        // Directions: Right, Down, Left, Up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = -1; // Mark as visited

        int minTime = 0;
        while (!q.isEmpty()) 
        {
            int[] cell = q.poll();
            int time = cell[0], row = cell[1], col = cell[2];

            // update the minTime
            minTime = Math.max(minTime, time);

            // If we reach the bottom-right corner return the result
            if (row == n - 1 && col == n - 1) 
            return minTime;

            // Explore all 4 directions
            for (int[] dir : directions) 
            {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] != -1) 
                {
                    q.add(new int[]{grid[newRow][newCol], newRow, newCol});
                    grid[newRow][newCol] = -1; // Mark as visited
                }
            }
        }

        // Return whatever the fuck you want to
        return -1; 
    }
}