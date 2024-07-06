class Solution {
    public int nextNumber(int n)
    {
        int res=0;
        while(n>0)
        {
            int num=(n%10);
            res+=num*num;
            n/=10;
        }
        return res;
    }

    public boolean isHappy(int num) 
    {
        int slow=num;
        int fast=num;
        while(fast!=1)
        {
            slow=nextNumber(slow);
            fast=nextNumber(nextNumber(fast));
            if(fast!=1 && slow==fast)
            return false;
        }
        return true;
    }
}