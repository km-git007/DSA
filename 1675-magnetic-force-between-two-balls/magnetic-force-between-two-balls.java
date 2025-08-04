class Solution {

    private boolean isValid(int[] position, int totalBalls, int gap){
        int ballsPlaced = 1, prevPosition = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - prevPosition >= gap){
                prevPosition = position[i];
                ballsPlaced++;
            }
            if(ballsPlaced == totalBalls) 
            return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int balls)
    {
        Arrays.sort(position);
        int end = position[position.length - 1] - position[0];
        int start = 1;

        int maxForce = end;
        while(start <= end)
        {
            int mid = start + (end - start) /2;
            if(isValid(position, balls, mid))
            {
                maxForce = mid;
                start = mid + 1;
            }
            else
            end = mid - 1;
        }
        return maxForce;
    }
}