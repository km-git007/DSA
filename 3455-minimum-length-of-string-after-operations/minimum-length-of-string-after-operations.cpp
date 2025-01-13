class Solution {
public:
    int minimumLength(string s) 
    {
        int map[26] = {0};
        for(char c : s)
        map[c - 'a']++;

        int res = 0;
        for(int i = 0;i < 26; i++)
        {
            if(!map[i])
            continue;

            res += (map[i] % 2 == 0 ? 2 : 1);
        }
        return res;
    }
};