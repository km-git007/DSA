class Solution {
    private Long[][] dp;
    private long solve(int index, int currDrink, int[] energyDrinkA, int[] energyDrinkB)
    {
        if(index >= energyDrinkA.length)
        return 0;

        if(dp[index][currDrink] != null)
        return dp[index][currDrink];

        long drinkBoost = currDrink == 0 ? energyDrinkA[index] : energyDrinkB[index];
        
        // two choices
        long notSwitch = solve(index + 1, currDrink, energyDrinkA, energyDrinkB);
        long switchDrink = solve(index + 2, 1 - currDrink, energyDrinkA, energyDrinkB);
        
        return dp[index][currDrink] = drinkBoost + Math.max(notSwitch, switchDrink);
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) 
    {
        dp = new Long[energyDrinkA.length][2];
        return Math.max(solve(0, 0, energyDrinkA, energyDrinkB), solve(0, 1, energyDrinkA, energyDrinkB));
    }
}