class Solution {

    int n,m;
    // Directions for moving up, down, left, and right
    private static final int[][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    private int bfs(Queue<int[]> queue,char[][] maze, int[] entrance)
    {
        int steps = 0;
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++)
            {
                int[] coordinates = queue.poll();
                int x = coordinates[0];
                int y = coordinates[1];
                
                if((x==0 || x == n-1 || y==0 || y == m-1) && (x != entrance[0] || y != entrance[1]))
                return steps;
                
                for(int[] dir : directions)
                {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX<n && newY >= 0 && newY<m && maze[newX][newY]=='.')
                    {
                        maze[newX][newY] = '+';
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public int nearestExit(char[][] maze, int[] entrance)
    {
        n=maze.length;
        m=maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';  // Recommended to mark entrance as visited

        return bfs(queue,maze,entrance);
    }
}