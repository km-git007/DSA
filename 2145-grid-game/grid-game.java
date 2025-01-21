class Solution {
    public long gridGame(int[][] grid) 
    {
        long firstRowSum = Arrays.stream(grid[0]).asLongStream().sum();
        long secondRowSum = 0, minSum = Long.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++)
        {
            firstRowSum -= grid[0][i];
            minSum = Math.min(minSum, Math.max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][i];
        }
        return minSum;
    }
}