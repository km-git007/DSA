class Solution {
public:
    int minSubArrayLen(int target, vector<int>& a) 
    {
        int minLength=1e9;
        int i=0,sum=0;
        for(int j=0;j<a.size();j++)
        {
            sum+=a[j];

            while(sum>=target)
            {
                minLength=min(minLength,j-i+1);
                sum-=a[i];
                i++;
            }
        }
        return (minLength==1e9)?0:minLength;
    }
};