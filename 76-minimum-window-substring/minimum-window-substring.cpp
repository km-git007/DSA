class Solution {
public:
    string minWindow(string s, string t) 
    {
        if(s.length() < t.length())
        return "";

        unordered_map<char,int> map;
        for(char ch : t)
        map[ch]++;

        int matches = 0, startIndex = -1, minLength = s.length();
        int i = 0;
        for(int j = 0; j < s.length(); j++)
        {
            char ch = s[j];
            if(map.count(ch) > 0)
            {
                map[ch]--;
                if(map[ch] == 0)
                matches++;
            }
            
            while(matches == map.size())
            {
                if(j - i + 1 <= minLength)
                {
                    minLength = j - i + 1;
                    startIndex = i;
                }

                char ch1 = s[i];
                if(map.count(ch1) > 0)
                {
                    map[ch1]++;
                    if(map[ch1] == 1)
                    matches--;
                }
                i++;
            }
        }
        return startIndex == -1 ? "" : s.substr(startIndex, minLength);
    }
};