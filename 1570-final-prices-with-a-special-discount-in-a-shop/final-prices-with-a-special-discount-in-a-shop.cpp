class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) 
    {
        int n = prices.size();
        vector<int> res(n);
        stack<int> s;
        for(int i = n - 1; i >= 0; i--)
        {
            while(!s.empty() && prices[i] < s.top())
            s.pop();

            if(s.empty())
            res[i] = prices[i];
            else
            res[i] = prices[i] - s.top();

            s.push(prices[i]);
        }
        return res;
    }
};