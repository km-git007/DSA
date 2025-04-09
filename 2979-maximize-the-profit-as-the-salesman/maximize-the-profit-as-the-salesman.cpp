class Solution {
public:
    vector<int> dp;
    int findNextIndex(int start, int target, vector<vector<int>>& offers)
    {
        int end = offers.size() - 1;
        // very important think why?
        int res = offers.size();
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(offers[mid][0] > target)
            {
                res = mid;
                end = mid - 1;
            }
            else
            start = mid + 1;
        }
        return res;
    }

    int solve(int index, vector<vector<int>>& offers)
    {
        if(index >= offers.size())
        return 0;

        if(dp[index] != -1)
        return dp[index];

        int notTake = solve(index + 1, offers);

        int nextIndex = findNextIndex(index + 1, offers[index][1], offers);
        int take = offers[index][2] + solve(nextIndex, offers);

        return dp[index] = max(take, notTake);
    }

    int maximizeTheProfit(int n, vector<vector<int>>& offers) 
    {
        sort(offers.begin(), offers.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];  // ascending order based on first element
        });

        dp = vector<int>(offers.size(), -1);
        return solve(0, offers);
    }
};