class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<3 || nums[0]>0)
        return ans;

        // nums=[-2,-2,-2,-1,-1,0,0,0,0,1,1,1,2,2,3,3]
        int n=nums.length;
        for(int i=0;i<n-2;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
            continue;

            int j=i+1,k=n-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    List<Integer> temp=new ArrayList<>();
                    Collections.addAll(temp,nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    // ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1])
                    j++;
                    while(j<k && nums[k]==nums[k+1])
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0)
                j++;
                else
                k--;
            }
        }
        return ans;
    }
}