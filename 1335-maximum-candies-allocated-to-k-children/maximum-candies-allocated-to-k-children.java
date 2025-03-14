class Solution {
    private boolean validDistribution(int[] candies, long k, int maxCandy)
    {
        long childrenServed = 0;
        for(int candy : candies)
        {
            childrenServed += candy / maxCandy;
            if(childrenServed >= k)
            return true;
        }
        return false;
    }

    public int maximumCandies(int[] candies, long k) 
    {
        int start = 1;
        int end = Arrays.stream(candies).max().getAsInt();
        int maxCandy = 0;
        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            if(validDistribution(candies, k, mid)) 
            {
                maxCandy = mid;
                start = mid + 1;
            } 
            else 
            end = mid - 1;
        }
        return maxCandy;
    }
}