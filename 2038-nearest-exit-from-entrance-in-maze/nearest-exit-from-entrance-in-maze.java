class Solution {

    int n,m;
    // Directions for moving up, down, left, and right
    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int bfs(Queue<int[]> queue, char[][] maze, int[] entrance)
    {
        int steps = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];

                if((row == 0 || row == n - 1 || col == 0 || col == m - 1) && (row != entrance[0] || col != entrance[1])){
                    return steps;
                }

                for(var dir : directions){
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if(x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != '+'){
                        queue.offer(new int[]{x, y});
                        maze[x][y] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public int nearestExit(char[][] maze, int[] entrance)
    {
        n = maze.length;
        m = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        //mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';  

        return bfs(queue,maze,entrance);
    }
}