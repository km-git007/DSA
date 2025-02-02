class Solution {
    private Long[][] dp;
    private long solve(int index, int canDrinkB, int[] energyDrinkA, int[] energyDrinkB)
    {
        if(index >= energyDrinkA.length)
        return 0;

        if(dp[index][canDrinkB] != null)
        return dp[index][canDrinkB];

        long switchDrink = -1, notSwitch = -1;
        if(canDrinkB == 0)
        {
            notSwitch = energyDrinkA[index] + solve(index + 1, 0, energyDrinkA, energyDrinkB);
            switchDrink = energyDrinkA[index] + solve(index + 2, 1, energyDrinkA, energyDrinkB);
        }
        else
        {
            notSwitch = energyDrinkB[index] + solve(index + 1, 1, energyDrinkA, energyDrinkB);
            switchDrink = energyDrinkB[index] + solve(index + 2, 0, energyDrinkA, energyDrinkB);
        }
        
        return dp[index][canDrinkB] = Math.max(notSwitch, switchDrink);
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) 
    {
        dp = new Long[energyDrinkA.length][2];
        return Math.max(solve(0, 0, energyDrinkA, energyDrinkB), solve(0, 1, energyDrinkA, energyDrinkB));
    }
}