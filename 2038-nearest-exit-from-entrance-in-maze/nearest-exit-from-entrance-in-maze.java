class Solution {

    int n,m;
    // Directions for moving up, down, left, and right
    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int bfs(Queue<int[]> queue, char[][] maze, int[] entrance)
    {
        int steps = 0;
        int startRow = entrance[0], startCol = entrance[1];
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];

                if(row == startRow && col == startCol){
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
        int startRow = entrance[0], startCol = entrance[1];
        for(int i = 0; i < n; i++){
            if(maze[i][0] == '.' && (i != startRow || 0 != startCol)){
                queue.offer(new int[]{i, 0});
                maze[i][0] = '+';
            }
            if(maze[i][m - 1] == '.' && (i != startRow || m - 1 != startCol)){
                queue.offer(new int[]{i, m - 1});
                maze[i][m - 1] = '+';
            }
        }

        for(int j = 0; j < m; j++){
            if(maze[0][j] == '.' && (0 != startRow || j != startCol)){
                queue.offer(new int[]{0, j});
                maze[0][j] = '+';
            }
            if(maze[n - 1][j] == '.' && (n - 1 != startRow || j != startCol)){
                queue.offer(new int[]{n - 1, j});
                maze[n - 1][j] = '+';
            }
        }
        return bfs(queue,maze,entrance);
    }
}