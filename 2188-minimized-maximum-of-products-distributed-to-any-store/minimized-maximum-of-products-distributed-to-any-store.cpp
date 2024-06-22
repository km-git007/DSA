class Solution {
public:
    bool isValid(vector<int>& quantities,int stores,int productCap)
    {
        int storesServed=0;
        for(int i=0;i<quantities.size();i++)
        {
            storesServed+=ceil(quantities[i]*1.0/productCap);
            if(storesServed>stores)
            return false;
        }
        return true;
    }

    int minimizedMaximum(int stores, vector<int>& quantities) 
    {
        int end=*max_element(quantities.begin(),quantities.end());
        int start=1;
        int res=-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isValid(quantities,stores,mid))
            {
                res=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }  
        return res;
    }
};