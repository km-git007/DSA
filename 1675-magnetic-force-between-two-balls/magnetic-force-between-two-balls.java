class Solution {

    public boolean isValid(int[] position,int m,int minForce)
    {
        int balls=1;
        int previousBallPosition=position[0];
        for(int i=1;i<position.length;i++)
        {
            if(position[i]-previousBallPosition>=minForce)
            {
                previousBallPosition=position[i];
                balls++;
            }
            if(balls>=m)
            return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int m) 
    {
        Arrays.sort(position);
        int end=position[position.length-1]-position[0];
        // int end=Arrays.stream(position).max().orElse(0);
        int start=1;  // Find the minimum element in position

        int maxForce=end;
        // checking if this amount of position is fine
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            // checking if balls can be done in position lesser than what we took right now
            if(isValid(position,m,mid))
            {
                maxForce=mid;
                start=mid+1;
            }
            // means we need to increase the amont of position
            else
                end=mid-1;
        }  
        return maxForce;
    }
}