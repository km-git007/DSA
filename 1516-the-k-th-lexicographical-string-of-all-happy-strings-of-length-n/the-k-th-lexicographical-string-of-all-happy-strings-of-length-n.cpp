class Solution {
public:

    vector<char> vec={'a','b','c'};
    priority_queue<string> pq;
    string s="";
    void solve(int n,int k)
    {
        if(n==0)
        {
            pq.push(s);
            if(pq.size()>k)
            pq.pop();
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

        if(pq.size()<k)
        return "";
        return pq.top();
    }
};