class Solution {

    public int minFallingPathSum(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        
        List<Integer> prev = new ArrayList<>();

        // initialize the first column
        for(int j = 0; j < m; j++)
        prev.add(grid[0][j]);

        int INF = Integer.MAX_VALUE/2;
        for(int i = 1; i < n; i++)
        {
            // create a new list for the current row dp values
            List<Integer> curr = new ArrayList<>(Collections.nCopies(m, 0));
            for(int j = 0; j < m; j++)
            {
                int left = j - 1 >= 0 ? prev.get(j - 1) : INF;
                int right = j + 1 < m ? prev.get(j + 1) : INF;
                int up = prev.get(j);

                curr.set(j, grid[i][j] + Math.min(up, Math.min(left, right)));
            }
            prev = curr;
        }

        // find the minimum from the last row
        int res = prev.get(0);
        for(int j = 1; j < m; j++)
        res = Math.min(res, prev.get(j));

        return res;
    }
}