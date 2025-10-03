class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            numBottles = empty / numExchange;
            empty = empty % numExchange + numBottles;
            res += numBottles;
        }
        return res;
    }
}