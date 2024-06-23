#pragma GCC optimize("O3","unroll-loops")
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        ios::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        // if the diff between the max and min element of an subarray < k then all other 
        // elements' diff is also < k
        int n = nums.size();
        if(nums.size()==0)return 0;
        // we will keep queue to track the index of max and min element in current window 
        // q1 will track max and subsequent index value will decrease 
        // q2 will track min and subsequent index value will increase 
        deque<int>q1,q2;   
        int i=0,j=0,ans=0;
        while(j<n){
            // to maintain order - if new element is greater than last element 
            // remove last and insert current element in q1  vice versa for q2
            while(!q1.empty() && nums[q1.back()]<nums[j])q1.pop_back();
            while(!q2.empty() && nums[q2.back()]>nums[j])q2.pop_back();
            q1.push_back(j);
            q2.push_back(j);
            while(!q1.empty() && !q2.empty() &&
             (nums[q1.front()] - nums[j]>limit || nums[j]-nums[q2.front()]>limit)){
                if(nums[q1.front()] - nums[j]>limit){
                    i= max(i,q1.front()+1);
                    q1.pop_front();
                }
                if(nums[j]-nums[q2.front()]>limit){
                    i= max(i,q2.front()+1);
                    q2.pop_front();
                }
             }
            ans=max(ans,j-i+1);
            j++;
        }
        return ans;
    }
};