class Solution {
public:
    int maxBottlesDrunk(int numBottles, int numExchange) 
    {
        int ans=numBottles;
        int empty=numBottles;
        numBottles=0;
        while(numBottles!=0 or empty>=numExchange)
        {
            if(empty>=numExchange)
            {
                numBottles++;
                empty-=numExchange;
                numExchange++;
            }
            else
            {
                empty+=numBottles;
                ans+=numBottles;
                numBottles=0;
            }
        }
        return ans;
    }
};