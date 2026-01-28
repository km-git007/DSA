class Solution {
    private int[] dp;
    private int earnPoints(int i, int[] nums){
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        int take = nums[i];
        
        int index = i - 1;
        while(index >= 0 && nums[index] == nums[i]){
            take += nums[index];
            index--;
        }
        
        while(index >= 0 && nums[index] == nums[i] - 1){
            index--;
        }
        
        take += earnPoints(index, nums);

        int skip = earnPoints(i - 1, nums);
        return dp[i] = Math.max(take, skip);
    }

    public int deleteAndEarn(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        Arrays.sort(nums);
        return earnPoints(nums.length - 1, nums);
    }
}