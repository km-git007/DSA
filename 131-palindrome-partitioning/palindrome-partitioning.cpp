class Solution {
public:
    vector<vector<string>> ans;
    vector<string> temp;
    int dp[17][17];
    bool check(string &s,int i,int j)
    {
        if(i>=j)
        return true;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(s[i]!=s[j])
        return dp[i][j]=false;
        
        return dp[i][j]=check(s,i+1,j-1);
    }

    void solve(string &s,int start)
    {
        if(start==s.length())
        {
            ans.push_back(temp);
            return;
        }

        for(int i=1;i<=s.length()-start+1;i++)
        {
            if(check(s,start,start+i-1))
            {
                string str=s.substr(start,i);
                temp.push_back(str);
                solve(s,start+i);
                temp.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) 
    {
        memset(dp,-1,sizeof(dp));
        solve(s,0);
        return ans;
    }
};