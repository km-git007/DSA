class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& a, int k) 
    {
        int i=0;
        vector<int> ans;
        deque<int> l;          
        for(int j=0;j<a.size();j++)
        {
            while(!l.empty() and a[j]>l.back())
            l.pop_back();

            l.push_back(a[j]);

            if(j-i+1==k)
            {
                int front=l.front();
                ans.push_back(front);
                if(a[i]==front)
                l.pop_front();
                i++;
            }
        }
        return ans;
    }
};