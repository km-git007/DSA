class Solution {

    // Directions for moving up, down, left, and right
    private final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    int n,m,freshCount;
    private int bfs(Queue<int[]> q,int[][] grid) 
    { 
        int time=0; 
        while (!q.isEmpty()) 
        {
            int levelSize=q.size();
            boolean hasRotten=false;
            for(int j=0;j<levelSize;j++)
            {
                int[] currCell=q.poll();
                int currRow=currCell[0];
                int currCol=currCell[1]; 
                for (int[] dir : directions) 
                {
                    int row=currRow+dir[0];
                    int col=currCol+dir[1];
                    // Check if the new position is within bounds and not visited.
                    if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1) 
                    {
                        q.add(new int[]{row,col});
                        grid[row][col]=2;
                        freshCount--;
                        hasRotten=true;
                    }
                }
            }
            if(!hasRotten)
            break;
            time++;
        }
        return time;
    }

    public int orangesRotting(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        freshCount=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                q.add(new int[]{i,j}); 

                if(grid[i][j]==1)
                freshCount++;
            }
        }
        int time=bfs(q,grid);
        return (freshCount==0)?time:-1;
    }
}