class Solution {
public:
    string smallestSubsequence(string s) 
    {
        string ans="";
        vector<int> taken(26,0);
        vector<int> lastIndex(26);

        for(int i=0;i<s.length();i++)
        lastIndex[s[i]-'a']=i;

        for(int i=0;i<s.length();i++)
        {
            if(taken[s[i]-'a'])
            continue;

            while(!ans.empty() && s[i]<ans.back() && lastIndex[ans.back()-'a']>i)
            {
                taken[ans.back()-'a']=0;
                ans.pop_back();
            }

            ans.push_back(s[i]);
            taken[s[i]-'a']=1;
        }
        return ans;
    }
};