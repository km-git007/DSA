class Solution {
    private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n, m;
    int id;
    private int bfs(int[][] grid, int row, int col, int id) 
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = id; // Mark the cell with a unique id
        int count = 1; // Count the current land cell

        while (!queue.isEmpty()) 
        {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : DIRECTIONS) 
            {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (isValidCell(newRow, newCol) && grid[newRow][newCol] == 1) 
                {
                    grid[newRow][newCol] = id; // Mark as visited
                    queue.offer(new int[]{newRow, newCol});
                    count++;
                }
            }
        }
        return count;
    }


    public int largestIsland(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        id = 2;

        // map {id, size}
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // Handle empty water cases
        
        int largestIsland = 0;
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j < m; j++) 
            {
                if(grid[i][j] == 1) 
                {
                    int islandSize = bfs(grid, i, j, id);
                    largestIsland = Math.max(largestIsland, islandSize);
                    map.put(id, islandSize);
                    id++;
                }
            }
        }

        // flip the zero and then find the largest island
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j < m; j++) 
            {
                if(grid[i][j] == 0) 
                {
                    // Flipping 0 to 1
                    int islandSize = 1;
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for(int[] dir : DIRECTIONS) 
                    {
                        int row = i + dir[0];
                        int col = j + dir[1];

                        if(isValidCell(row, col))
                        uniqueIslands.add(grid[row][col]);
                    }

                    for(int islandId : uniqueIslands)
                    islandSize += map.get(islandId);
                    
                    largestIsland = Math.max(largestIsland, islandSize);
                }
            }
        }
        return largestIsland;
    }

    private boolean isValidCell(int row, int col)
    {
        return (row >= 0 && row < n && col >= 0 && col < m);
    }
}