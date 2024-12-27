class Solution {
public:

    vector<int> findAnagrams(string s, string p) 
    {
        vector<int> res;

        unordered_map<char,int> map;
        for(int i = 0; i < p.length(); i++)
        map[p[i]]++;

        int count = map.size();
        int i = 0;
        for(int j = 0; j < s.length(); j++)
        {
            if(map.count(s[j]) > 0)
            {
                map[s[j]]--;
                if(!map[s[j]])
                count--;
            }

            if(j - i + 1 == p.length())
            {
                if(count == 0)
                res.push_back(i);

                if(map.count(s[i]) > 0)
                {
                    map[s[i]]++;
                    if(map[s[i]] == 1)
                    count++;
                }
                i++;
            }
        }
        return res;
    }
};