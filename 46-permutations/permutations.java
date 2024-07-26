class Solution {

    List<List<Integer>> ans;
    List<Integer> list;
    private void solve(int[] nums)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=-11)
            {
                int val=nums[i];
                list.add(val);
                nums[i]=-11;
                solve(nums);
                list.remove(list.size()-1);
                nums[i]=val;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        ans=new ArrayList<>();
        list=new ArrayList<>();
        solve(nums);
        return ans;
    }
}