class Solution {
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n = position.length;
        double[][] pair = new double[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = (double) (target - position[i]) / (speed[i]);;
        }
        Arrays.sort(pair, Comparator.comparingDouble(a -> a[0]));

        int carFleet = 0;
        double prevTime = 0;
        for(int i = n - 1; i >= 0; i--) {
            double timeTaken = pair[i][1];
            if(timeTaken > prevTime) {
                carFleet++;
                prevTime = timeTaken;
            }
        }
        return carFleet;
    }
}