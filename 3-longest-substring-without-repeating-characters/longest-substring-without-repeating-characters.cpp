class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
        unordered_map<char, int> map;
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++)    
        {
            map[s[j]]++;
            while(j - i + 1 > map.size())
            {
                map[s[i]]--;

                if(map[s[i]] == 0)
                map.erase(s[i]);

                i++;
            }
            maxLen = max(maxLen, j - i + 1);
        }
        return maxLen;
    }
};