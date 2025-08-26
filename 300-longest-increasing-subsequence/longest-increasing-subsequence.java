class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis = 1;
        int[] lisEndingAtIth = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            lisEndingAtIth[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    lisEndingAtIth[i] = Math.max(lisEndingAtIth[j] + 1, lisEndingAtIth[i]);
                }
            }
            lis = Math.max(lis, lisEndingAtIth[i]);
        }
        return lis;
    }
}