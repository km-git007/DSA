class Solution {
public:
    bool isIsomorphic(string s, string t) 
    {
        unordered_map<char,char> map;
        unordered_set<char> set;

        for(int i=0;i<s.length();i++)
        {
            if(map.count(s[i])==0)
            {
                if(set.count(t[i])==0)
                {
                    map[s[i]]=t[i];
                    set.insert(t[i]);
                }
                else
                return false;
            }
            else
            {
                if(map[s[i]]!=t[i])
                return false;
            }
        }
        return true;
    }
};