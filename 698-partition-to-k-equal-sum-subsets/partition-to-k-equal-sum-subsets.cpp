class Solution {
public:
    vector<int> vis;
    int target;
    bool solve(vector<int>& nums, int k,int sum,int index)
    {
        if(k==0)
        return true;

        if(sum==0)
        return solve(nums,k-1,target,0);
        
        for(int i=index;i<nums.size();i++)
        {
            if(!vis[i] && sum>=nums[i])
            {
                vis[i]=1;
                if(solve(nums,k,sum-nums[i],i+1))
                return true;
                vis[i]=0;
            }
        }
        return false;
    }

    bool canPartitionKSubsets(vector<int>& nums, int k) 
    {
        int n=nums.size();
        int sum=accumulate(nums.begin(),nums.end(),0);

        if(sum%k!=0 || n<k)
        return false;

        vis=vector<int>(n,0);
        target=sum/k;
        return solve(nums,k,target,0);
    }
};