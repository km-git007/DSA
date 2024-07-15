class Solution {
public:

    bool isValid(vector<int>& a,int k,int sum)
    {
        int parts=1;
        int currSum=0;
        for(int i=0;i<a.size();i++)
        {
            currSum+=a[i];
            if(currSum>sum)
            {
                parts++;
                currSum=a[i];
            }

            if(parts>k)
            return false;
        }
        return true;
    }

    int splitArray(vector<int>& a, int k) 
    {
        int sum=0;
        int start=*max_element(a.begin(),a.end());
        int end=accumulate(a.begin(),a.end(),sum);
        int minSum=end;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(isValid(a,k,mid))
            {
                minSum=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return minSum;
    }
};