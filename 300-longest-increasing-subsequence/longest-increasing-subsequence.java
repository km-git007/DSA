class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < n; i++)
        {
            int num = nums[i];
            Integer ceil = treeSet.ceiling(num);

            if(ceil != null)
            treeSet.remove(ceil);

            treeSet.add(num);
        }
        return treeSet.size();
    }
}