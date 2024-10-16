class Solution {
public:

    bool validSpeed(vector<int>& piles, int h,int speed)
    {
        int time = 0;
        for(int pile : piles)
        {
            time += (pile/speed) + (pile%speed == 0 ? 0 : 1);
            if(time > h)
            return false;
        }
        return true;
    }

    int minEatingSpeed(vector<int>& piles, int h)  // guard returns after h hours.
    {
        int start = 1;
        int end = *max_element(piles.begin(),piles.end());
        int minEatingSpeed=end;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(validSpeed(piles,h,mid))
            {
                minEatingSpeed=mid;
                end=mid-1;
            }
            else
            start=mid+1;
        }
        return minEatingSpeed;
    }
};