class Solution {
public:

    int countSubarraysSumGreaterThanK(vector<int>& a, int k)
    {
        int n=a.size();
        int sum=0,count=0,i=0;
        for(int j=0;j<n;j++)
        {
            sum+=a[j];
            while(i<=j && sum>=k)   // a = [0,0,0,0,0]
            {
                count+=n-j;
                sum-=a[i];
                i++;
            }
        }
        return count;
    }

    int numSubarraysWithSum(vector<int>& a, int k) 
    {
        return countSubarraysSumGreaterThanK(a,k)-countSubarraysSumGreaterThanK(a,k+1);
    }
};