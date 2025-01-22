class Solution {

    // direction for moving up, down, left, right
    private static final int[][] direction = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int[][] highestPeak(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;

        // {row, col, height}
        Queue<int[]> queue = new LinkedList<>();

        int[][] res = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        // Start BFS from every water cell 
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) 
        {
            int level = queue.size();
            while(level > 0)
            {
                // Process the current node
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int height = current[2];

                res[row][col] = height;

                // Explore neighbors
                for (int[] direction : direction) 
                {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Check boundaries and whether the cell is already visited
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                            && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol, height + 1});
                    }
                }
                level--;
            }

        }
        return res;
    }
}