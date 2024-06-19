class Solution {
public:
    bool isValid(vector<int>& bloomDay, int m,int k,int day)
    {
        int bouquets=0;
        int flowers=0;
        for(int i=0;i<bloomDay.size();i++)
        {
            if(bloomDay[i]<=day)
            {
                flowers++;
                if(flowers==k)
                {
                    bouquets++;
                    flowers=0;
                }
            }
            else
                flowers=0;
            if(bouquets>=m)
            return true;
        }
        return false;
    }

    int minDays(vector<int>& bloomDay, int m, int k) 
    {
        int start=*min_element(bloomDay.begin(),bloomDay.end());
        int end=*max_element(bloomDay.begin(),bloomDay.end());
        int minDaysNeeded=-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(isValid(bloomDay,m,k,mid))
            {
                minDaysNeeded=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return minDaysNeeded;
    }
};