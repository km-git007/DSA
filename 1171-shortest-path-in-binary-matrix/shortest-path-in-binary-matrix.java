class Solution {
    private static int[][] directions = {
        {0, -1}, {1, 0}, {0, 1}, {-1, 0},  // Left, Down, Right, Up
        {-1, -1}, {1, 1}, {1, -1}, {-1, 1} // Diagonals: top-left, bottom-right, bottom-left, top-right
    };

    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        if(grid[0][0] == 1)
        return -1;

        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        int dist = 1;
        while (!queue.isEmpty()) 
        {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) 
            {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                if(x == n - 1 && y == n - 1)
                return dist;

                for (int[] dir : directions) 
                {
                    int row = x + dir[0];
                    int col = y + dir[1];
                    if(row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) 
                    {
                        grid[row][col] = 1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}