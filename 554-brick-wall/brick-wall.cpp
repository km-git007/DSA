class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) 
    {
        // {pos, count of Brick Edges}
        unordered_map<long long, int> map;
        int maxEdges = 0;
        for(int i = 0; i < wall.size(); i++)
        {
            long long pos = 0;
            // Exclude the last brick in each row
            for(int j = 0; j < wall[i].size() - 1; j++)
            {
                pos += wall[i][j];
                map[pos]++;
                maxEdges = max(maxEdges, map[pos]);
            }
        }
        return wall.size() - maxEdges;
    }
};