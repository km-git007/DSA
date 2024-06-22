class Solution{
private:
bool check(vector<int>& quantities , int n , int mid)
{
    int count = 0;
    for(auto a : quantities)
    {
        if(a%mid == 0)count += (a/mid);
        else count += (a/mid)+1;
        if( count > n) return false;
    }
    return true;
}

public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        cout.tie(NULL);
        int lo = 1;
        int hi = *max_element(quantities.begin() , quantities.end());
        int mid;
        int ans;
       
        while(lo <= hi)
        {
            mid = lo + (hi-lo)/2;
            if( check(quantities , n , mid))
            {
                ans = mid;
                hi = mid-1;
            }
            else
            {
                lo = mid+1;
            }
        }
        return ans; 
    }
};