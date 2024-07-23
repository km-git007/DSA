class Solution {

    // Directions for moving up, down, left, and right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    int n,m;
    private int bfs(Queue<int[]> q,char[][] maze, int[] entrance) 
    {
        int steps=-1,nearestExitDistance=-1;
        while (!q.isEmpty()) 
        {
            int levelSize=q.size();
            steps++;
            for(int j=0;j<levelSize;j++)
            {
                int[] currCell=q.poll();
                int currRow=currCell[0];
                int currCol=currCell[1];

                if(currRow==entrance[0] && currCol==entrance[1])
                nearestExitDistance=steps;

                for (int i=0;i<4;i++) 
                {
                    int row=currRow+rowDir[i];
                    int col=currCol+colDir[i];
                    if(row>=0 && row<n && col>=0 && col<m && maze[row][col]=='.') 
                    {
                        q.offer(new int[]{row,col});
                        maze[row][col]='+';
                    }
                }
            }
        }
        return nearestExitDistance;
    }

    public int nearestExit(char[][] maze, int[] entrance) 
    {
        n=maze.length;
        m=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(maze[i][j]=='.' && (i==0 || j==0 || i==n-1 || j==m-1))
                if(i!=entrance[0] || j!=entrance[1])
                {
                    q.offer(new int []{i,j});
                    maze[i][j]='+';              // marking the current cell as visited
                }
            }
        }
        return bfs(q,maze,entrance);
    }
}