class Solution {
public:
    vector<string> ans;
    int n;
    void solve(string &s,int open,int closed)
    {
        if(open==n && closed==n)
        {
            ans.push_back(s);
            return;
        }

        if(open<n)
        {
            s.push_back('(');
            solve(s,open+1,closed);
            s.pop_back();
        }

        if(closed<open)
        {
            s.push_back(')');
            solve(s,open,closed+1);
            s.pop_back();
        }
    }
    
    vector<string> generateParenthesis(int N) 
    {
        string s="";
        n=N;
        solve(s,0,0);
        return ans;
    }
};