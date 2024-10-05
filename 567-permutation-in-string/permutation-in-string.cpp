class Solution {
public:

    bool checkInclusion(string p, string s) 
    {
        unordered_map<char,int> m;
        for(char c: p)
        m[c]++;

        int i=0,count=m.size();
        for(int j=0;j<s.length();j++)
        {
            if(m.find(s[j])!=m.end())
            {
                m[s[j]]--;
                if(m[s[j]]==0)
                count--;
            }
            if(j-i+1==p.length())
            {
                if(count==0)
                return true;

                if(m.find(s[i])!=m.end())
                {
                    m[s[i]]++;
                    if(m[s[i]]==1)
                    count++;
                }
                i++;
            }
        }
        return false;
    }
};