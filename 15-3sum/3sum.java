class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> ans=new ArrayList<>();
         // Sort the array to handle duplicates easily
        Arrays.sort(nums);

        int n=nums.length;
        if(n<3 || nums[0]>0)
        return ans;

        for(int i=0;i<n-2;i++)
        {
            // Skip duplicate elements
            if(i>0 && nums[i]==nums[i-1])
            continue;

            int j=i+1;
            HashSet<Integer> set=new HashSet<>();
            while(j<n)
            {
                int target=-(nums[i]+nums[j]);
                if(set.contains(target))
                {
                    ans.add(Arrays.asList(nums[i], nums[j], target));
                    set.add(nums[j]);
                    j++;

                    while(j<n && nums[j]==nums[j-1])
                    j++;
                }

                else
                {
                    set.add(nums[j]);
                    j++;
                }
            }
        }
        return ans;
    }
}