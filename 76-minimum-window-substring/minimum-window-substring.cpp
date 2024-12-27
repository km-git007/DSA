class Solution {
public:
    string minWindow(string s, string t) 
    {
        if(t.length() > s.length())
        return "";

        unordered_map<char,int> map;
        for(char c : t)
        map[c]++;

        int i = 0, count = map.size(), startIndex = -1, minLength = s.length();
        for(int j = 0; j < s.length(); j++)
        {
            if(map.count(s[j]) > 0)
            {
                map[s[j]]--;
                if(map[s[j]] == 0)
                count--;
            }

            while(count == 0)
            {
                if(j - i + 1 <= minLength)
                {
                    startIndex = i;
                    minLength = j - i + 1;
                }

                if(map.count(s[i]) > 0)
                {
                    map[s[i]]++;
                    if(map[s[i]] == 1)
                    count++;
                }
                i++;
            }
        }
        return (startIndex == -1) ? "" : s.substr(startIndex, minLength);
    }
};