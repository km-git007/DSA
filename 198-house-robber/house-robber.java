class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxMoneyTwoHousesBack = nums[0];
        int maxMoneyOneHouseBack = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int maxMoneyAtCurrentHouse = Math.max(
                maxMoneyOneHouseBack,                    // Skip current house
                maxMoneyTwoHousesBack + nums[i]         // Rob current house
            );
            
            maxMoneyTwoHousesBack = maxMoneyOneHouseBack;
            maxMoneyOneHouseBack = maxMoneyAtCurrentHouse;
        }
        
        return maxMoneyOneHouseBack;
    }
}
