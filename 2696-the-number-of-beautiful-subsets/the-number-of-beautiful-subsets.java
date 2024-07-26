class Solution {

    HashMap<Integer,Integer> map=new HashMap<>();
    private int solve(int index,int[] nums,int k)
    {
        if(index==nums.length)
        return 1;

        int subsets=solve(index+1,nums,k);
        if(!map.containsKey(nums[index]+k) && !map.containsKey(nums[index]-k))
        {
            map.put(nums[index],map.getOrDefault(nums[index],0)+1);
            subsets+=solve(index+1,nums,k);
            map.put(nums[index],map.get(nums[index])-1);

            if(map.get(nums[index])==0) 
            map.remove(nums[index]);
        }
        return subsets;
    }

    public int beautifulSubsets(int[] nums, int k) 
    {
        // Arrays.sort(nums);
        return solve(0,nums,k)-1;
    }
}