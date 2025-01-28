class Solution {
    int[] dir = new int[] {-1, 0, 1, 0, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        List<int[]> thiefs = new ArrayList<>();
        int m = grid.size(), n = grid.get(0).size(), ans = 0;
        int low = 0, high = 0;
        int[][] safeness = new int[m][n];
        high = buildSafenessAndReturnMax(safeness, m, n, grid);
        
        // while(low <= high) {
        //     int mid = (low + high) / 2;
        //     if(check(mid, m, n, safeness)) {
        //         // System.out.println(mid);
        //         ans = mid;
        //         low = mid + 1;
        //     } else {
        //         high = mid - 1;
        //     }
        // }

        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[] {0, 0, safeness[0][0]});
        ans = safeness[0][0];
        safeness[0][0] = -1;
        while(!dq.isEmpty()) {
            int x = dq.peekFirst()[0], y = dq.peekFirst()[1], safe = dq.pollFirst()[2];
            ans = Math.min(ans, safe);
            if(x == m - 1 && y == n - 1) {
                break;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int dx = x + dir[i], dy = y + dir[i + 1];
                if(dx < 0 || dx == m || dy < 0 || dy == n || safeness[dx][dy] == -1) {
                    continue;
                }
                if(safeness[dx][dy] >= ans) {
                    dq.offerFirst(new int[] {dx, dy, safeness[dx][dy]});
                } else {
                    dq.offerLast(new int[] {dx, dy, safeness[dx][dy]});
                }
                safeness[dx][dy] = -1;
            }
        }
        return ans;
    }

    boolean check(int val, int m, int n, int[][] grid) {
        if(grid[0][0] < val || grid[m - 1][n - 1] < val) {
            return false;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.offer(new int[] {0, 0});
        vis[0][0] = true;
        while(!q.isEmpty()) {
            int x = q.peek()[0], y = q.poll()[1];
            if(x == m - 1 && y == n - 1) {
                return true;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int dx = x + dir[i], dy = y + dir[i + 1];
                if(dx < 0 || dy < 0 || dx == m || dy == n || vis[dx][dy] || grid[dx][dy] < val) {
                    continue;
                }
                q.offer(new int[] {dx, dy});
                vis[dx][dy] = true;
            }
        }
        return false;
    }

    int buildSafenessAndReturnMax(int[][] arr, int m, int n, List<List<Integer>> grid) {
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[] {i, j, 0});
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            int x = q.peek()[0], y = q.peek()[1], dist = q.poll()[2];
            for(int i = 0 ; i < 4 ; i++) {
                int dx = x + dir[i], dy = y + dir[i + 1];
                if(dx < 0 || dy < 0 || dx == m || dy == n || arr[dx][dy] != -1) {
                    continue;
                }
                q.offer(new int[] {dx, dy, 1 + dist});
                arr[dx][dy] = dist + 1;
                max = Math.max(max, dist + 1);
            }
        }
        // for(int[] row: arr) {
        //     System.out.println(Arrays.toString(row));
        // }
        return max;
    }
}