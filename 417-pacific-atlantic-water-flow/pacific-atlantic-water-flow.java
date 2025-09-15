class Solution {
    private int n, m;
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean isValidCell(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    
    private void BFS(int[][] heights, boolean[][] visited, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            for(int[] d : directions){
                int row = d[0] + i;
                int col = d[1] + j;
                if(isValidCell(row, col) && !visited[row][col] && heights[i][j] <= heights[row][col]){
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }

        for(int j = 0; j < m; j++){
            queue.offer(new int[]{0, j});
            pacific[0][j] = true;
        }

        BFS(heights, pacific, queue);
        queue.clear();

        for(int i = 0; i < n; i++){
            queue.offer(new int[]{i, m - 1});
            atlantic[i][m - 1] = true;
        }

        for(int j = 0; j < m; j++){
            queue.offer(new int[]{n - 1, j});
            atlantic[n - 1][j] = true;
        }

        BFS(heights, atlantic, queue);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }
}