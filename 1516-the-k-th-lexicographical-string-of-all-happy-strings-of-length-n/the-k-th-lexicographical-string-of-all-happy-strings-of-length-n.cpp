class Solution {
public:

    vector<char> vec={'a','b','c'};
    string s="",ans;
    int count=0;
    void solve(int n,int k)
    {
        if(count==k)
        return;

        if(n==0)
        {
            count++;
            if(count==k)
            ans=s;
            return;
        }

        for(int i=0;i<3;i++)
        {
            if(s.empty() || s.back()!=vec[i])
            {
                s.push_back(vec[i]);
                solve(n-1,k);
                s.pop_back();
            }
        }
    }

    string getHappyString(int n, int k) 
    {
        solve(n,k);

        if(count<k)
        return "";
        return ans;
    }
};