class Solution {

    private int n, m;
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private final int INF = 1000000000;
    private boolean[][] visited;
    private boolean canFireReachSafeHouse(int waitingTime, int[][] grid, int[][] fireTime)
    {
        // reassign the vis array for reuse
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], false);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        int time = waitingTime;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                var currentCell = queue.poll();
                int row = currentCell[0];
                int col = currentCell[1];

                for(int[] direction : directions) {
                    int nextRow = currentCell[0] + direction[0];
                    int nextCol = currentCell[1] + direction[1];
                    if(isValidCell(nextRow, nextCol) && grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        if(nextRow == n - 1 && nextCol == m - 1) {
                            return time + 1 <= fireTime[nextRow][nextCol];
                        }
                        if(time + 1 < fireTime[nextRow][nextCol]) {
                           visited[nextRow][nextCol] = true;
                           queue.offer(new int[] {nextRow, nextCol});
                        }
                    }
                }
            }
            time++;
        }
        return false;
    }

    private void findFireTime(int[][] grid, int[][] fireTime)
    {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // add the fire cells in the queue
                if(grid[i][j] == 1) {
                    fireTime[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
                // wall and grass
                else {
                    fireTime[i][j] = INF;
                }
            }
        }

        while(!queue.isEmpty()) {
                var cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for(var direction : directions){
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if(isValidCell(nextRow, nextCol) && grid[nextRow][nextCol] == 0 && fireTime[nextRow][nextCol] == INF){
                        queue.offer(new int[] {nextRow, nextCol});
                        // Mark as visited now to avoid adding it multiple fireTimes
                        fireTime[nextRow][nextCol] = fireTime[row][col] + 1;
                    }
                }
        }
    }

    private boolean isValidCell(int row, int col)
    {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private int binarySearch(int[][] grid, int[][] fireTime){
        int start = 0;
        int end = INF;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(canFireReachSafeHouse(mid, grid, fireTime)){
                result = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return result;
    }
    public int maximumMinutes(int[][] grid)
    {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int[][] fireTime = new int[n][m];
        findFireTime(grid, fireTime);

        int minStayTime = binarySearch(grid, fireTime);
        // If fire never reaches exit but the person can reach exit, return max possible time
        if(minStayTime != -1 && fireTime[n - 1][m - 1] == INF) {
            return INF;
        }
        return minStayTime;
    }
}