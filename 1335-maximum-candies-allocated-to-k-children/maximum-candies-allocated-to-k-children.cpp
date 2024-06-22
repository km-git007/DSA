class Solution {
public:

    bool isValid(vector<int>& candies,long long k,long long maxCandy)
    {
        long long childrenServed=0;
        for(int i=0;i<candies.size();i++)
        {
            childrenServed+=candies[i]/maxCandy;
            if(childrenServed>=k)
            return true;
        }
        return false;
    }

    int maximumCandies(vector<int>& candies, long long k) 
    {
        long long end=*max_element(candies.begin(),candies.end());
        long long start=1;
        long long result=-1;
        while(start<=end)
        {
            long long mid=start+(end-start)/2;
            if(isValid(candies,k,mid))
            {
                result=mid;
                start=mid+1;
            }
            else
                end=mid-1;
        }  
        return (result==-1)?0:result;
    }
};