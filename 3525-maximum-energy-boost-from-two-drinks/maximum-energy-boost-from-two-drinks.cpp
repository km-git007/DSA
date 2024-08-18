class Solution {
public:
    int n;
    long long dp[100001][3];
    long long solve(int index,int drinkA,vector<int>& energyDrinkA, vector<int>& energyDrinkB)
    {
        if(index>=n)
        return 0;

        if(dp[index][drinkA]!=-1)
        return dp[index][drinkA];

        long long maxEnergy=0;
        if(drinkA)
        {
            // drink A and not switch
            long long A1=energyDrinkA[index]+solve(index+1,1,energyDrinkA,energyDrinkB);
            // drink A and switch
            long long A2=energyDrinkA[index]+solve(index+2,0,energyDrinkA,energyDrinkB);
            maxEnergy=max(A1,A2);
        }
        else
        {
            // drink B and not switch
            long long B1=energyDrinkB[index]+solve(index+1,0,energyDrinkA,energyDrinkB);
            // drink B and switch
            long long B2=energyDrinkB[index]+solve(index+2,1,energyDrinkA,energyDrinkB);
            maxEnergy=max(B1,B2);
        } 
        return dp[index][drinkA]=maxEnergy;
    }

    long long maxEnergyBoost(vector<int>& energyDrinkA, vector<int>& energyDrinkB) 
    {
        n=energyDrinkA.size();
        memset(dp,-1,sizeof(dp));
        long long startWithA=solve(0,1,energyDrinkA,energyDrinkB);
        long long startWithB=solve(0,0,energyDrinkA,energyDrinkB);
        return max(startWithA,startWithB);
    }
};