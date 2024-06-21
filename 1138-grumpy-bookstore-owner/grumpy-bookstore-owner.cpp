class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) 
    {
        int maxExtraSatisfaction=0,extraSatisfaction=0,satisfaction=0;
        int i=0;
        for(int j=0;j<grumpy.size();j++)
        {
            if(grumpy[j]!=1)
            satisfaction+=customers[j];
            else
            extraSatisfaction+=customers[j];

            if(j-i+1==minutes)
            {
                maxExtraSatisfaction=max(maxExtraSatisfaction,extraSatisfaction);
                if(grumpy[i]==1)
                extraSatisfaction-=customers[i];
                i++;
            }
        }
        return satisfaction+maxExtraSatisfaction;
    }
};