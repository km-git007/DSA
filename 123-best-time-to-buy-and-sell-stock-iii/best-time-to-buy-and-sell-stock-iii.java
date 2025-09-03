class Solution {
    private Integer[][][] dp;
    private int stock(int index, int canBuy, int k, int[] prices){
        if(k == 0 || index >= prices.length){
            return 0;
        }
        
        if(dp[index][canBuy][k] != null){
            return dp[index][canBuy][k];
        }

        int maxProfit = 0;
        if(canBuy == 1){
            int buy = stock(index + 1, 1 - canBuy, k, prices) - prices[index];
            int notBuy = stock(index + 1, canBuy, k, prices);
            maxProfit = Math.max(buy, notBuy);
        }
        else{
            int sell = stock(index + 1, 1 - canBuy, k - 1, prices) + prices[index];
            int notSell = stock(index + 1, canBuy, k, prices);
            maxProfit = Math.max(sell, notSell);
        }
        return dp[index][canBuy][k] = maxProfit;
    }

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return stock(0, 1, 2, prices);
    }
}