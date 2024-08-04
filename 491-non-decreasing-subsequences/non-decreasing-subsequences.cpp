class Solution {
public:
    vector<int> temp;
    vector<vector<int>> ans;
    set<vector<int>> set;
    void solve(vector<int>& a,int index)
    {
        if(temp.size()>=2)
        {
            if(!set.count(temp))
            {
                set.insert(temp);
                ans.push_back(temp);
            }
        }

        for(int i=index;i<a.size();i++)
        {
            if(temp.size()==0 || temp.back()<=a[i])
            {
                temp.push_back(a[i]);
                solve(a,i+1);
                temp.pop_back();
            }
        }
    }

    vector<vector<int>> findSubsequences(vector<int>& a) 
    {
        solve(a,0);
        return ans;
    }
};