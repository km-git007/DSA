class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) 
    {
        unordered_map<string,int> map1;
        string curr1="";
        for(int i=0;i<s1.length();i++)
        {
            if(s1[i]==' ')
            {
                map1[curr1]++;
                curr1="";
                continue;
            }
            curr1.push_back(s1[i]);
            if(i==s1.length()-1)
            map1[curr1]++;
        }

        unordered_map<string,int> map2;
        string curr2="";
        for(int i=0;i<s2.length();i++)
        {
            if(s2[i]==' ')
            {
                map2[curr2]++;
                curr2="";
                continue;
            }
            curr2.push_back(s2[i]);
            if(i==s2.length()-1)
            map2[curr2]++;
        }

        vector<string> ans;
        for(auto x : map1)
        {
            if(!map2.count(x.first))
            {
                if(x.second==1)
                ans.push_back(x.first);
            }
        }

        for(auto x : map2)
        {
            if(!map1.count(x.first))
            {
                if(x.second==1)
                ans.push_back(x.first);
            }
        }
        return ans;
    }
};