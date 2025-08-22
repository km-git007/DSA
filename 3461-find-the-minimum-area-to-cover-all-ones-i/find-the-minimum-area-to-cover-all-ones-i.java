class Solution {
    public int minimumArea(int[][] grid) 
    {
        int n = grid.length, m = grid[0].length;
        int top = n, bottom = 0, left = m, right = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 0)
                continue;

                top = Math.min(top, i);
                bottom = Math.max(bottom, i);
                left = Math.min(left, j);
                right = Math.max(right, j);
            }
        }
        return  (bottom - top + 1) * (right - left + 1);
    }
}