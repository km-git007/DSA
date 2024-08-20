class Solution {
public:

    unordered_map<string,bool> map;
    bool check(string s,unordered_set<string> &set)
    {
        int n=s.length();

        if(n==0)
        return false;

        if(map.count(s)>0)
        return map[s];

        for(int i=1;i<=n;i++)
        {
            string s1=s.substr(0,i);
            string s2=s.substr(i,n-i);

            bool case1= set.count(s1)>0 && set.count(s2)>0;
            if(case1)
            return map[s]=true;

            bool case2= set.count(s1)>0 && check(s2,set);
            if(case2)
            return map[s]=true;
        }
        return map[s]=false;
    }

    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) 
    {
        vector<string> ans;
        unordered_set<string> set(words.begin(),words.end());
        for(string word : words)
        {
            if(check(word,set))
            ans.push_back(word);
        }
        return ans;
    }
};