class Solution {
    private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n, m;
    int id;
    private int dfs(int[][] grid, int row, int col, int id) 
    {
        if(!isValidCell(row, col) || grid[row][col] != 1)
        return 0;
        
        // mark the cell with unique id
        grid[row][col] = id;

        // Count current land cell
        int count = 1; 
        
        // Explore all 4 directions using the DIRECTIONS array
        for(int[] dir : DIRECTIONS) 
        count += dfs(grid, row + dir[0], col + dir[1], id);
        
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
                    int islandSize = dfs(grid, i, j, id);
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