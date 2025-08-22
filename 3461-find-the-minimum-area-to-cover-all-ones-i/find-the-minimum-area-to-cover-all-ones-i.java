class Solution {
    public int minimumArea(int[][] grid) 
    {
        int top = -1, bottom = -1, left = -1, right = -1;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 0)
                continue;

                if(top == -1)
                {
                    top = bottom = i;
                    left = right = j;
                }
                else
                {
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        int maxArea = (bottom - top + 1) * (right - left + 1);
        return top == -1 ? 0 : maxArea;
    }
}