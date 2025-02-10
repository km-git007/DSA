class NeighborSum {

    int[][] dia, adj, grid;
    Map<Integer, int[]> map;
    public NeighborSum(int[][] grid) 
    {
        map = new HashMap<>();
        this.grid = grid;
        dia = new int[][]{{-1,-1}, {-1,1}, {1,-1}, {1,1}};
        adj = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            map.put(grid[i][j], new int[]{i, j});
        }
    }

    private int sumOfNeighbours(int value, boolean isAdj)
    {
        int[] coordinates = map.get(value);
        int r = coordinates[0], c = coordinates[1];

        int sum = 0;
        for(int i = 0; i < 4; i++)
        {
            int row = r + (isAdj ? adj[i][0] : dia[i][0]);
            int col = c + (isAdj ? adj[i][1] : dia[i][1]);
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length)
            sum += grid[row][col];
        }
        return sum;
    }
    
    public int adjacentSum(int value) 
    {
        return sumOfNeighbours(value, true);
    }
    
    public int diagonalSum(int value) 
    {
        return sumOfNeighbours(value, false);
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */