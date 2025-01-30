class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int[] dp = new int[k+1];
        int count = 0;

        for(List<Integer> pile : piles){

            int n = Math.min(pile.size(), k);
            int[] preSum = new int[n+1];
            int sum = 0;
            for(int i = 0 ; i < n; ++i){
               sum += pile.get(i);
               preSum[i + 1] = sum;
            }

            count += n;

            for(int i = Math.min(k, count); i > 0; --i){
              int cur = dp[i];
              for(int j = Math.min(n, i); j > 0; --j)
                  cur = Math.max(cur, dp[i - j] + preSum[j]);
              
               dp[i] = cur;              
            }

        }
        
        return dp[k];
    }
}