class Solution {
    private Integer[] dp;
    private int solve(int[] nums, int target){
        if(target == 0)
        return 1;

        if(dp[target] != null){
            return dp[target];
        }

        int count = 0;
        for(int num : nums){
            if(num > target){
                break;
            }
            count += solve(nums, target - num);
        }
        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        Arrays.sort(nums);
        return solve(nums, target);
    }
}