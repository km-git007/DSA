class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private List<List<Integer>> dp;
    public void initializeDP(int n) 
    {
        for (int i = 0; i < n; i++) 
        {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++)
            row.add(-1); 
            dp.add(row);
        }
    }

    private int solve(int row, int col, List<List<Integer>> triangle)
    {
        if(row >= triangle.size() || col >= triangle.get(row).size())
        return INF;

        if(row == triangle.size() - 1)
        return triangle.get(row).get(col);

        if(dp.get(row).get(col) != -1)
        return dp.get(row).get(col);

        int minPathSum = triangle.get(row).get(col) + Math.min(solve(row + 1, col, triangle), solve(row + 1, col + 1, triangle));
        dp.get(row).set(col, minPathSum);

        return minPathSum;
    }

    public int minimumTotal(List<List<Integer>> triangle) 
    {
        dp = new ArrayList<>();
        initializeDP(triangle.size());
        return solve(0, 0, triangle);
    }
}