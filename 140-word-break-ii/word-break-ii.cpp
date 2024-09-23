class Solution {
private:
    vector<string> ans;
    unordered_set<string> set;
    void solve(string s,string temp,int start)
    {
        if(start==s.length())
        {
            temp.pop_back();
            ans.push_back(temp);
            return;
        }

        string curr="";
        for(int i=start;i<s.length();i++)
        {
            curr.push_back(s[i]);
            if(set.count(curr))
            solve(s,temp+curr+" ",i+1);
        }
    }

public:
    vector<string> wordBreak(string s, vector<string>& wordDict) 
    {
        for(string word : wordDict)
        set.insert(word);

        string temp="";
        solve(s,temp,0);
        return ans;
    }
};