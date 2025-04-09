class Solution {
public:
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

    int maximizeTheProfit(int N, vector<vector<int>>& offers) 
    {
        int n = offers.size();
        sort(offers.begin(), offers.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];  // ascending order based on first element
        });

        vector<int> dp(n);
        dp[n - 1] = offers[n - 1][2];

        for(int i = n - 2; i >= 0; i--)
        {
            int take = offers[i][2];

            int nextIndex = findNextIndex(i + 1, offers[i][1], offers);
            take += nextIndex < n ? dp[nextIndex] : 0;

            int notTake = dp[i + 1];

            dp[i] = max(take, notTake);
        }
        return dp[0];
    }
};