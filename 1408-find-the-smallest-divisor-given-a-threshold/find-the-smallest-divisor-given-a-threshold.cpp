class Solution {
public:
    int sumOfDivisors(vector<int>&nums,int mid){
        int n=nums.size();
        int sum=0;
        for(int i=0;i<n;i++){
            // sum=sum+ceil((double)nums[i]/mid);
            sum=sum+(nums[i]+mid-1)/mid;
        }
        return sum;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        ios_base::sync_with_stdio(false);

        int maxEle=*max_element(nums.begin(),nums.end());

        int low=1,high=maxEle;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            int sum=sumOfDivisors(nums,mid);
            if(sum<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return low;
    }
};