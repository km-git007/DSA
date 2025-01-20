class Solution {
public:
    string minWindow(string s, string t) 
    {
        if(s.length() < t.length())
        return "";

        unordered_map<char,int> map;
        for(char c : t)
        map[c]++;

        int count = map.size(), i = 0;
        int startIndex = -1, minLength = s.length();
        for(int j = 0; j < s.length(); j++)
        {
            if(map.count(s[j]))
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

                if(map.count(s[i]))
                {
                    map[s[i]]++;
                    if(map[s[i]] == 1)
                    count++;
                }

                i++;
            }
        }
        return startIndex == -1 ? "" : s.substr(startIndex, minLength);
    }
};