class Solution {
    public int maxSatisfied(int[] cust, int[] grumpy, int minutes) 
    {
        int satisfiedCustomers=0;
        for(int i=0;i<cust.length;i++)
        {
            if(grumpy[i]==0)
            satisfiedCustomers+=cust[i];
        }

        int maxExtraSatisfiedCustomers=0;
        int i=0,extraSatisfiedCustomers=0;
        for(int j=0;j<cust.length;j++)
        {
            if(grumpy[j]==1)
            extraSatisfiedCustomers+=cust[j];

            if(j-i+1==minutes)
            {
                maxExtraSatisfiedCustomers=Math.max(maxExtraSatisfiedCustomers,extraSatisfiedCustomers);
                if(grumpy[i]==1)
                extraSatisfiedCustomers-=cust[i];
                i++;
            }
        }
        satisfiedCustomers+=maxExtraSatisfiedCustomers;
        return satisfiedCustomers;
    }
}