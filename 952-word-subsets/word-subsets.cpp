class Solution {
public:

    unordered_map<int,int> buildMap(string &word)
    {
        unordered_map<int,int> map;
        for(char c : word)
        map[c - 'a']++;
        return map;
    }

    vector<int> buildMaxFreqMap(vector<string>& words)
    {
        vector<int> maxFreq(26, 0);
        for(string word : words)
        {
            auto map = buildMap(word);
            for(auto x : map)
            if(maxFreq[x.first] < x.second)
            maxFreq[x.first] = x.second;
        }
        return maxFreq;
    }

    bool check(vector<int> &maxFreq, string &word)
    {
        auto map = buildMap(word);
        for(int i = 0; i < 26; i++)
        {
            if(maxFreq[i])
            {
                if(!map.count(i) || map[i] < maxFreq[i])
                return false;
            }
        }
        return true;
    }

    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) 
    {
        // build a maxFreq map from words2
        auto maxFreq = buildMaxFreqMap(words2);

        vector<string> res;
        for(string word : words1)
        {
            if(check(maxFreq, word))
            res.push_back(word);
        }
        return res;
    }
};