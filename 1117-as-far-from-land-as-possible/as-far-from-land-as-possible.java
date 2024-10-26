class Solution {

    int n,m;
    // Directions for moving up, down, left, and right
    private final int[][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    private int bfs(Queue<int[]> queue,int[][] grid) 
    { 
        int dist = -1;
        while (!queue.isEmpty()) 
        {
            int levelSize=queue.size();
            for(int j=0;j<levelSize;j++)
            {
                int[] currCell = queue.poll();
                int currRow = currCell[0];
                int currCol = currCell[1];
                for (int[] dir : directions) 
                {
                    int row = currRow + dir[0];
                    int col = currCol + dir[1];
                    if(row >=0 && col >= 0 && row < n && col < m && grid[row][col] == 0)
                    {
                        queue.add(new int[]{row,col});
                        grid[row][col] = 1;
                    }
                }
            }
            dist++;
        }
        return dist;
    }

    public int maxDistance(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        boolean hasOneWaterCell = false;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                queue.add(new int[]{i,j});
                else
                hasOneWaterCell = true;
            }
        }
        
        if(queue.isEmpty() || !hasOneWaterCell)
        return -1;

        return bfs(queue,grid);
    }
}