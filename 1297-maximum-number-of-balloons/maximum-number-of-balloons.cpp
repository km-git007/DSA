class Solution {
public:
    int maxNumberOfBalloons(string text) 
    {
        unordered_set<char> set = {'b', 'a', 'l', 'o', 'n'};
        unordered_map<char, int> map;

        for(char ch : text)
        {
            if(set.count(ch))
            map[ch]++;
        }

        if(map.size() < 5)
        return 0;

        int instances = INT_MAX;
        for (auto& entry : map) 
        {
            char key = entry.first;
            int value = (key == 'l' || key == 'o') ? entry.second / 2 : entry.second;

            instances = min(instances, value);
        }
        return instances;
    }
};
