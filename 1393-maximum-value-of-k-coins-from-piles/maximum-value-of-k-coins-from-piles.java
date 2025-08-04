class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int[][] dp = new int[piles.size() + 1][k + 1];
        for(int index = 1; index <= piles.size(); index++){
            for(int coins = 1; coins <= k; coins++){
                int notTake = dp[index - 1][coins];
                int take = 0, total  = 0;
                for(int i = 0; i < piles.get(index - 1).size() && i < coins; i++){
                    total += piles.get(index - 1).get(i);
                    take = Math.max(take, total + dp[index - 1][coins - i - 1]);
                }
                dp[index][coins] = Math.max(notTake, take);
            }
        }
        return dp[piles.size()][k];
    }
}