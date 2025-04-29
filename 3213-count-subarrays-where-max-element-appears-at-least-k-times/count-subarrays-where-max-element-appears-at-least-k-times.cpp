class Solution {
public:
    long long countSubarrays(vector<int>& a, int k) 
    {
        int maxi = *max_element(a.begin(),a.end());
        int n = a.size(), i = 0; 
        long long count = 0, freq = 0;
        for(int j = 0; j < n; j++)
        {
            if(a[j] == maxi)
            freq++;
            while(freq == k)
            {
                count += n - j;          // counting all subarrays starting from i.
                if(a[i] == maxi)
                freq--;
                i++;
            }
        }
        return count;
    }
};