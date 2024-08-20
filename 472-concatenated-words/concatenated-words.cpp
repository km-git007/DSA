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
            string prefix=s.substr(0,i);
            string suffix=s.substr(i,n-i);

            if((set.count(prefix)>0 && set.count(suffix)>0) || (set.count(prefix)>0 && check(suffix,set)))
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