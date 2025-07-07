class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) 
    {
        int n = customers.size(), satisfaction = 0, maxExtra = 0, extra = 0;
        for(int i = 0; i < n; i++)
        {
            if(!grumpy[i])
            satisfaction += customers[i];

            else
            extra += customers[i];

            if(i - minutes + 1 >= 0)
            {
                maxExtra = max(maxExtra, extra);
                if(grumpy[i - minutes + 1])
                extra -= customers[i - minutes + 1];
            }
        }
        return satisfaction + maxExtra;
    }
};