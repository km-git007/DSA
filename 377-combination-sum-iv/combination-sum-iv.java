class Solution {

    int[] dp = new int[1001];
    private int solve(int[] nums, int target)
    {
        if(target == 0)
        return 1;

        if(target < 0)
        return 0;

        if(dp[target] != -1)
        return dp[target];

        int comb = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > target)
            break;

            comb += solve(nums, target - nums[i]);
        }
        return dp[target] = comb;
    }

    public int combinationSum4(int[] nums, int target) 
    {
        Arrays.sort(nums);
        Arrays.fill(dp, -1);
        return solve(nums, target);
    }
}