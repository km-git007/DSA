class Solution {
    private List<List<Integer>> res;
    private List<Integer> temp;
    private void solve(int[] nums, int target, int index){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(nums[i] > target)
            break;

            if(i > index && nums[i] == nums[i - 1])
            continue;

            temp.add(nums[i]);
            solve(nums, target - nums[i], i + 1);
            temp.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        
        Arrays.sort(nums);
        solve(nums, target, 0);
        return res;
    }
}