class Solution {
public:
    int numberOfSubarraysGreaterThanK(vector<int>& a, int k)
    {
        int count=0;
        int i=0,odd=0;
        for(int j=0;j<a.size();j++)
        {
            if(a[j]%2==1)
            odd++;

            while(odd>=k)
            {
                count+=a.size()-j;
                if(a[i]%2==1)
                odd--;
                i++;
            }
        }
        return count;
    }
    
    int numberOfSubarrays(vector<int>& a, int k) 
    {
        return numberOfSubarraysGreaterThanK(a,k)-numberOfSubarraysGreaterThanK(a,k+1);
    }
};