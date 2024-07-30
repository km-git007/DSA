class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) 
    {
        int n=arr.size();
        int sum[n];
        sum[0]=arr[0];
        for(int i=1;i<n;i++)
        sum[i]=sum[i-1]+arr[i];

        int oddSum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if((i-j+1)%2==1)
                {
                    oddSum+=(sum[i]-sum[j]+arr[j]);
                }
            }
        }
        return oddSum;
    }
};