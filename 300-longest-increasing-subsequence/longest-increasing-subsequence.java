class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            Integer ceiling = treeSet.ceiling(num);
            if (ceiling != null) {
                treeSet.remove(ceiling);
            }
            treeSet.add(num);
        }
        return treeSet.size();
    }
}