class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) 
    {
        vector<int> res;
        unordered_map<int, int> indexMap, colorMap;
        for(auto query : queries)
        {
            int index = query[0];
            int color = query[1];

            // if a ball is present at the index already
            if(indexMap.count(index))
            {
                // fetch the color of the ball already present at the index
                int ballColor = indexMap[index];

                // decrease the count of this color in the color map
                colorMap[ballColor]--;

                // remove this ball from the colorMap if count becomes '0'
                if(!colorMap[ballColor])
                colorMap.erase(ballColor);
            }

            // map the color to the index
            indexMap[index] = color;
            // increase the frequency of the color in the colorMap
            colorMap[color]++;

            // push the number of distict color balls in the res
            // i.e push the size of the colorMap
            res.push_back(colorMap.size());
        }

        return res;
    }
};