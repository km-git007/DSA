class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        leftSum[0] = 0;
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        
        int pivot = -1;
        if(leftSum[leftSum.length - 1] == 0){
            pivot = nums.length - 1;
        }

        int rightSum = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(leftSum[i] == rightSum){
                pivot = i;
            }
            rightSum += nums[i];
        }
        return pivot;
    }
}