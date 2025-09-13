class Solution {
    private int count;
    private Set<Integer> set;
    private void solve(int index, int[] nums, int k){
        if(index >= nums.length){
            count++;
            return;
        }

        //skip
        solve(index + 1, nums, k);

        //pick
        if(!set.contains(nums[index] - k)){
            set.add(nums[index]);
            solve(index + 1, nums, k);
            set.remove(nums[index]);
        }
    }

    public int beautifulSubsets(int[] nums, int k) {
        count = 0;
        set = new HashSet<>();
        Arrays.sort(nums);
        solve(0, nums, k);
        return count - 1;
    }
}