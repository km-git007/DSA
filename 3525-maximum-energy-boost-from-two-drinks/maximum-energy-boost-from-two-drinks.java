
class Solution {
    int n;
    long[][] dp;
    long solve(int index, int drinkA, int[] energyDrinkA, int[] energyDrinkB) 
    {
        if (index >= n)
        return 0;

        if (dp[index][drinkA] != -1) 
        return dp[index][drinkA];

        long maxEnergy = 0;
        if(drinkA==1) 
        {
            // drink A and not switch
            long A1 = energyDrinkA[index] + solve(index + 1, 1, energyDrinkA, energyDrinkB);
            // drink A and switch
            long A2 = energyDrinkA[index] + solve(index + 2, 0, energyDrinkA, energyDrinkB);
            maxEnergy = Math.max(A1, A2);
        }
        else 
        {
            // drink B and not switch
            long B1 = energyDrinkB[index] + solve(index + 1, 0, energyDrinkA, energyDrinkB);
            // drink B and switch
            long B2 = energyDrinkB[index] + solve(index + 2, 1, energyDrinkA, energyDrinkB);
            maxEnergy = Math.max(B1, B2);
        }
        return dp[index][drinkA] =maxEnergy;
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) 
    {
        n = energyDrinkA.length;
        dp = new long[n][2];
        for (long[] row : dp)
        Arrays.fill(row, -1);

        // maxEnergyBoost gained when you start with A
        long startWithA = solve(0, 1, energyDrinkA, energyDrinkB);
        // maxEnergyBoost gained when you start with B
        long startWithB = solve(0, 0, energyDrinkA, energyDrinkB);
        // take max of the two values
        return Math.max(startWithA, startWithB);
    }
}
