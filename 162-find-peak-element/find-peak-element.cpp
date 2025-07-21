class Solution {
public:
    int findPeakElement(vector<int>& a) 
    {
        int n=a.size();
        if(n==1)                    //a[]={1} 
        return 0;

        else if(a[0]>=a[1])         //a[]={3,1}  or  a[]={12,10,3,4,8,9,14,0}
        return 0;

        else if(a[n-1]>=a[n-2])     //a[]={1,3}  or a[]={2,10,3,4,8,9,14,20}
        return n-1;
    
        int low=1;
        int high=n-2;

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            // '=' sign used for arrays like a[]={1,3,3,3,3,3,0} //
            if(a[mid]>a[mid-1] and a[mid]>a[mid+1] )  
            return mid;                              

            else if(a[mid]<a[mid+1])
            low=mid+1;
            else
            high=mid-1;
        }

            return -1;
    }
};