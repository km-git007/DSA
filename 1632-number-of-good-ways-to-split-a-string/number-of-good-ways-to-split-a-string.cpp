class Solution {
public:
    int numSplits(string s) 
    {
        int n = s.length();
        unordered_map<char, int> map;

        vector<int> distinct(n, 0);
        for(int i = n - 1; i >= 0; i--)
        {
            distinct[i] = map.size();
            map[s[i]]++;
        }

        // clear the map
        map.clear();

        int goodWays = 0;
        for(int i = 0; i < n; i++)
        {
            map[s[i]]++;
            if(map.size() == distinct[i])
            goodWays++;
        }
        return goodWays;
    }
};