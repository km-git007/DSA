class Solution {
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, Comparator.comparingInt(a -> a[0]));
        
        for (int i = 0; i < n; i++) {
            position[i] = pair[i][0];
            speed[i] = pair[i][1];
        }
        
        
        int carFleet = 1;
        double time = (double) (target - position[n - 1]) / (speed[n - 1]);
        for(int i = n - 2; i >= 0; i--) {
            double timeTaken = (double) (target - position[i]) / (speed[i]);
            if(timeTaken > time) {
                carFleet++;
                time = timeTaken;
            }
        }
        return carFleet;
    }
}