class Solution {
public:
    int countOfSubarraysWithAtleastK(vector<int>& a, int k)
    {
        unordered_map<int,int> m;
        int n=a.size();
        int i=0,j=0,count=0;
        while(j<n)
        {
            m[a[j]]++;
            while(m.size()==k)
            {
                count+=n-j;             //total subarays starting from i and having grater than or equal to k elements.
                m[a[i]]--;
                if(m[a[i]]==0)
                m.erase(a[i]);
                i++;
            }
            j++;
        }
        return count;
    }

    int subarraysWithKDistinct(vector<int>& a, int k) 
    {
        return countOfSubarraysWithAtleastK(a,k)-countOfSubarraysWithAtleastK(a,k+1);
    }
    
};