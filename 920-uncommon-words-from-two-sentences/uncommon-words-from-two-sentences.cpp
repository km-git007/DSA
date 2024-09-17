class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) 
    {
        unordered_map<string,int> map;
        string word="";
        for(int i=0;i<s1.length();i++)
        {
            if(s1[i]==' ')
            {
                map[word]++;
                word="";
                continue;
            }
            word.push_back(s1[i]);
        }

        map[word]++;

        word="";
        for(int i=0;i<s2.length();i++)
        {
            if(s2[i]==' ')
            {
                map[word]++;
                word="";
                continue;
            }
            word.push_back(s2[i]);
        }

        map[word]++;

        vector<string> ans;
        for(auto x : map)
        {
            if(x.second==1)
            ans.push_back(x.first);
        }
        return ans;
    }
};