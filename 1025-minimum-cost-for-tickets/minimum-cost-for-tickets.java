class Solution {
    private int[] dp;
    private int[] pass = {1, 7, 30};
    private int findNextIndex(int[] days, int target) 
    {
        int low = 0, high = days.length - 1;
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            
            if(days[mid] <= target)
            low = mid + 1;

            else 
            high = mid - 1;
        }
        return low; // The next index where day > target
    }

    private int solve(int[] days, int[] costs, int index)
    {
        if(index >= days.length)
        return 0;

        if(dp[index] != -1)
        return dp[index];

        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < costs.length; i++)
        {
            int nextIndex = findNextIndex(days, days[index] + pass[i] - 1);
            if(nextIndex > index)
            minCost = Math.min(minCost, costs[i] + solve(days, costs, nextIndex));
        }

        return dp[index] = minCost;
    }

    public int mincostTickets(int[] days, int[] costs) 
    {
        dp = new int[days.length + 1];
        Arrays.fill(dp, -1);

        return solve(days, costs, 0);
    }
}