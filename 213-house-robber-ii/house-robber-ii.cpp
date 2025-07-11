class Solution {
public:
    int skipLast(vector<int>& a)
    {
        int n=a.size();
        if(n==1)
        return a[0];

        int prev2=a[0];                     // if only one house exists. We rob the house. As simple as that.
        int prev1=max(a[0],a[1]);           // if two house exists. we rob the house with max money.

        for(int i=2;i<n-1;i++)
        {
            int rob=prev2+a[i];
            int notRob=prev1;
            int curr=max(rob,notRob);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    int skipFirst(vector<int>& a)
    {
        int n=a.size();
        if(n==1)
        return a[1];

        int prev2=a[1];                     // if only one house exists. We rob the house. As simple as that.
        int prev1=max(a[2],a[1]);           // if two house exists. we rob the house with max money.

        for(int i=3;i<n;i++)
        {
            int rob=prev2+a[i];
            int notRob=prev1;
            int curr=max(rob,notRob);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    
    int rob(vector<int>& a) 
    {
        if(a.size()==1)
        return a[0];

        else if(a.size()==2)
        return max(a[0],a[1]);

        return max(skipFirst(a),skipLast(a));
    }
};