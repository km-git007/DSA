class Solution {
    private final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int n, m;

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private int solve(int[][] matrix) {
        int[][] outdegree = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: compute outdegree for each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (var direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (isValidCell(x, y) && matrix[x][y] > matrix[i][j]) {
                        outdegree[i][j]++;
                    }
                }
        // Step 2: push cells with outdegree == 0 (local maxima)
                if (outdegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }



        // Step 3: BFS layer by layer
        int longestIncreasingPath = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] node = queue.poll();
                int row = node[0], col = node[1];

                for (var direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];
                    if (isValidCell(x, y) && matrix[x][y] < matrix[row][col]) {
                        outdegree[x][y]--;
                        if (outdegree[x][y] == 0) {
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
            longestIncreasingPath++;
        }
        return longestIncreasingPath;
    }

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        return solve(matrix);
    }
}
