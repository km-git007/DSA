class Solution {
    
    public boolean isValid(int[] time, int totalTrips, long allotedTime)
    {
       long tripsDone = 0;
       for(int i = 0; i < time.length; i++)
       {
            tripsDone += (allotedTime / time[i]);
            if(tripsDone >= totalTrips)
            return true;
       }
       return false;
    }

    public long minimumTime(int[] time, int totalTrips) 
    {
        long end = Long.MAX_VALUE;
        long start = Arrays.stream(time).min().orElse(0);  // Find the minimum element in time

        long minimumTimeRequired = end;
        // checking if this amount of time is fine
        while(start <= end)
        {
            long mid = start + (end-start)/2;
            // checking if trips can be done in time lesser than what we took right now
            if(isValid(time, totalTrips,mid))
            {
                minimumTimeRequired = mid;
                end = mid-1;
            }
            // means we need to increase the amont of time
            else
            start = mid + 1;
        }  
        return minimumTimeRequired;
    }
}