class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashSet<Integer> set=new HashSet<>();
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            if(!set.add(nums[j]))
            return true;
            if(j-i==k)
            {
                set.remove(nums[i]);
                i++;
            }
        }
        return false;
    }
}