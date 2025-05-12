class Solution {
public:
    int LIS(vector<vector<int>>& env)
    {
        int n = env.size();
        set<long long> treeSet;
        // Apply LIS on heights
        for(int i = 0; i < n; i++)
        {
            int width = env[i][1];
            if(i > 0 && width == env[i - 1][1])
            continue;

            auto it = treeSet.lower_bound(width);

            if(it != treeSet.end())
            treeSet.erase(*it);

            treeSet.insert(width);
        }
        return treeSet.size();
    }

    int maxEnvelopes(vector<vector<int>>& envelopes) 
    {
        // Step 1: Sort by width ASC, height DESC
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>& a, const vector<int>& b){
            return a[0] == b[0] ? a[1] > b[1] : a[0] < b[0];
        });

        return LIS(envelopes);
    }
};