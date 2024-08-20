class Solution {
public:

    unordered_map<string,bool> dp;
    bool solve(string s,string t)
    {
        if(s==t)
        return true;

        if(s.length()!=t.length())
        return false;

        string key=s+" "+t;
        if(dp.count(key)>0)
        return dp[key];

        int n=s.length();
        for(int length=1;length<n;length++)
        {
            // No swapping is done
            bool noSwap=(solve(s.substr(0,length),t.substr(0,length)) && solve(s.substr(length),t.substr(length)));
            if(noSwap)
            return dp[key]=true;

            // Swapping is done
            bool swap=(solve(s.substr(0,length),t.substr(n-length)) && solve(s.substr(length),t.substr(0,n-length)));
            if(swap)
            return dp[key]=true;
        }
        return dp[key]=false;
    }

    bool isScramble(string s,string t) 
    {
        if(s==t)
        return true;

        return solve(s,t);
    }
};