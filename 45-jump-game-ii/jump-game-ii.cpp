class Solution {
public:
    int jump(vector<int>& a) 
    {
        int left=0,right=0,jumps=0;
        int maxReach=0;
        while(right<a.size()-1)
        {
            while(left<=right)
            {
                maxReach=max(maxReach,left+a[left]);
                left++;
            }
            left=right+1;
            right=maxReach;
            jumps++;
        }
        return jumps;
    }
};