class Solution {
    public int arrangeCoins(int n) {
        int coins = 1;
        int res = 0;
        while (n > 0) {
            n -= coins;
            coins += 1;
            if(n >= 0){
                res++;
            }
        }
        return res;
    }
}