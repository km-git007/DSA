class Solution {
public:
    bool isIsomorphic(string s, string t) 
    {
        unordered_map<char,char> map;
        unordered_set<char> set;
        for(int i=0;i<s.length();i++)
        {
            if(map.count(s[i])==0)          // given char is not present in map
            {
                if(set.count(t[i])==0)    // t[i] shouldn't be in set already means it should be unmapped. 
                {
                    map[s[i]]=t[i];
                    set.insert(t[i]);
                }
                else
                return false;               // t[i] in set already so returning false.
            }

            else                            // given char is already in map   
            {
                if(map[s[i]]!=t[i])
                return false;
            }
        }
        return true;
    }
};