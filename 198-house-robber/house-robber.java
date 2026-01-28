class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length == 1){
            return nums[0];
        }

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int maxGain = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = maxGain;
        }
        return curr;
    }
}