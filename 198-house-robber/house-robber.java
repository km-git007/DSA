class Solution {
    private int[] memo;
    private int robFrom(int[] houses, int i) {
        // Base case: no houses left
        if (i < 0) {
            return 0;
        }
        
        // Return cached result
        if (memo[i] != -1) {
            return memo[i];
        }
        
        // Rob current or skip current
        int robCurrent = houses[i] + robFrom(houses, i - 2);
        int skipCurrent = robFrom(houses, i - 1);
        
        // Cache and return
        return memo[i] = Math.max(robCurrent, skipCurrent);
    }
    
    public int rob(int[] houses) {
        memo = new int[houses.length];
        Arrays.fill(memo, -1);
        
        return robFrom(houses, houses.length - 1);
    }
}