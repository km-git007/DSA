class Solution {

    private boolean isValid(int[] dist, double speed, double timeToReach)
    {
       double time = 0;
       for(int i = 0; i < dist.length; i++)
       {
            time += (dist[i] / speed);
            if(time > timeToReach)
            return false;
            time = Math.ceil(time);
       }
       return true;
    }

    public int minSpeedOnTime(int[] dist, double hour) 
    {
        int end = 10000000;
        int start = 1;  

        int minSpeed = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            // checking if this speed is fine
            // if its fine then try for lesser speeds
            if(isValid(dist, mid, hour))
            {
                minSpeed = mid;
                end = mid-1;
            }
            // means we need to increase speed
            else
            start = mid + 1;
        }  
        return minSpeed;
    }
}