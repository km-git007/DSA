class Solution {
    private boolean validSpeed(int[] piles, int allotedTime, int speed)
    {
        int time = 0;
        for(int pile : piles)
        {
            time += Math.ceil(pile * 1.0 / speed);
            if(time > allotedTime)
            return false;
        }
        return true;
    }
    
    public int minEatingSpeed(int[] piles, int h) 
    {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int minEatingSpeed = end;
        while(start <= end) 
        {
            int mid = start + (end - start) / 2;
            if(validSpeed(piles, h, mid)) 
            {
                minEatingSpeed = mid;
                end = mid - 1;
            } 
            else 
            start = mid + 1;
        }
        // return the minimumSpeed
        return minEatingSpeed;
    }
}