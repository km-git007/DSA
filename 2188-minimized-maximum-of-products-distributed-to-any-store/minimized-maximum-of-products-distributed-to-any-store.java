class Solution {
    
    public boolean isValid(int[] quantities,int stores,double productCap)
    {
        int storesServed=0;
        for(int i=0;i<quantities.length;i++)
        {
            storesServed+=Math.ceil(quantities[i]/productCap);
            if(storesServed>stores)
            return false;
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) 
    {
        int end = Arrays.stream(quantities).max().orElse(0);
        int start=1;
        int result=-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isValid(quantities,n,mid))
            {
                result=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }  
        return result;
    }
}