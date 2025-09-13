class Solution {
    private List<List<Integer>> res;
    private List<Integer> temp;
    private void solve(int index, int[] nums, int target){
        if(target == 0){
            res.add(new ArrayList(temp));
            return;
        }

        if(index >= nums.length || target < 0)
        return;

        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            solve(i, nums, target - nums[i]);
            temp.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        
        Arrays.sort(nums);
        solve(0, nums, target);
        return res;
    }
}