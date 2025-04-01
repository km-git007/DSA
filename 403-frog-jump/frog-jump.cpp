// Custom hash function for pair<int, int>
struct pair_hash {
    template <class T1, class T2>
    size_t operator()(const pair<T1, T2>& p) const {
        return hash<T1>()(p.first) ^ (hash<T2>()(p.second) << 1);
    }
};

class Solution {
public:
    int n;
    unordered_map<int, int> map;
    // Unordered map with custom hash function
    unordered_map<pair<int, int>, bool, pair_hash> dp;

    bool solve(vector<int>& stones, int pos, int k)
    {
        // Reached last stone
        if(pos == stones.back())
        return true;

        // // Invalid jump or position
        if(k == 0 || !map.count(pos))
        return false;

        if (dp.count({pos, k})) 
        return dp[{pos, k}];
        
        bool canReach = solve(stones, pos + k - 1, k - 1) || solve(stones, pos + k, k) || solve(stones, pos + k + 1, k + 1);
        return dp[{pos, k}] = canReach;
    }

    bool canCross(vector<int>& stones) 
    {
        // First jump must be exactly 1
        if(stones[1] > 1)
        return false;

        n = stones.size();
        for(int i = 0; i < n; i++)
        map[stones[i]] = i;

        // Start from position 1 with jump size 1
        return solve(stones, 1, 1);
    }
};