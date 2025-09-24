class Solution {
public:
    int maxFrequencyElements(vector<int>& a) 
    {
        unordered_map<int,int> m;
        int maxFreq=0;
        for(int i=0;i<a.size();i++){
            m[a[i]]++;
            maxFreq=max(m[a[i]],maxFreq);
        }

        int count=0;
        for(auto x : m)
        {
            if(x.second==maxFreq)
            count+=maxFreq;
        }
        return count;
    }
};