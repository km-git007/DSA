class Solution {
    
    public boolean isValid(int[] time,int totalTrips,long allotedTime)
    {
        long trips=0;
        for(int i=0;i<time.length;i++)
        {
            trips+=allotedTime/time[i];
            if(trips>=totalTrips)
            return true;
        }
        return false;
    }

    public long minimumTime(int[] time, int totalTrips) 
    {
        long end=Long.MAX_VALUE;
        long start=Arrays.stream(time).min().orElse(0);  // Find the minimum element in time

        long minimumTimeRequired=end;
        while(start<=end)
        {
            long mid=start+(end-start)/2;
            if(isValid(time,totalTrips,mid))
            {
                minimumTimeRequired=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }  
        return minimumTimeRequired;
    }
}