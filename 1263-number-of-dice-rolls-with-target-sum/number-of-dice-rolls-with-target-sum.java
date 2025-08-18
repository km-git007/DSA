class Solution {
    private int MOD = 1000000007;
    private int totalFaces, totalDices;
    private long[][] dp;
    private long numberOfRolls(int diceNo, int target){
        if(diceNo > totalDices || target < 0) return 0;
        if(target == 0 ) return diceNo == totalDices ? 1 : 0;

        if(dp[diceNo][target] != -1) return dp[diceNo][target];

        long ways = 0;
        for(int face = 1; face <= totalFaces; face++){
            ways = (ways + numberOfRolls(diceNo + 1, target - face)) % MOD;
        }
        return dp[diceNo][target] = ways;
    }

    public int numRollsToTarget(int n, int k, int target) {
        totalFaces = k;
        totalDices = n;

        dp = new long[totalDices + 1][target + 1];
        for(int dice = 0; dice <= totalDices; dice++){
            Arrays.fill(dp[dice], -1);
        }

        return (int)numberOfRolls(0, target);
    }
}