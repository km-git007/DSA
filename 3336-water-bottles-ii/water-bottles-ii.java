class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) 
    {
        int totalBottlesDrank=numBottles;
        int emptyBottles=numBottles;
        int fullBottles=0;
        while(fullBottles>0 || emptyBottles>=numExchange)
        {
            if(fullBottles>0)
            {
                totalBottlesDrank+= fullBottles;
                emptyBottles+=fullBottles;
                fullBottles--;
            }
            else
            {
                emptyBottles-=numExchange;
                fullBottles++;
                numExchange++;
            }
        }
        return totalBottlesDrank;
    }
}