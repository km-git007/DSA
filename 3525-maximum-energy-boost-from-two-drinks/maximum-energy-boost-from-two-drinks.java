class Solution {
    public long maxEnergyBoost(int[] drinkA, int[] drinkB) 
    {
        int n = drinkA.length;
        long[] dpA = new long[n];
        long[] dpB = new long[n];

        dpA[0] = drinkA[0];
        dpB[0] = drinkB[0];
        dpA[1] = drinkA[0] + drinkA[1];
        dpB[1] = drinkB[0] + drinkB[1];

        for(int i = 2; i < n; i++)
        {
            dpA[i] = drinkA[i] + Math.max(dpB[i - 2], dpA[i - 1]);
            dpB[i] = drinkB[i] + Math.max(dpA[i - 2], dpB[i - 1]);
        }

        return Math.max(dpA[n -1], dpB[n - 1]);
    }
}