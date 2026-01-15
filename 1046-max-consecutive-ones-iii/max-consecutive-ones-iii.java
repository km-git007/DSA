class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0, zeroes = 0, i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == 0){
                zeroes++;
            }
            
            while(zeroes > k){
                if(nums[i] == 0){
                    zeroes--;
                }
                i++;
            }
            maxOnes = Math.max(maxOnes, j - i + 1);
        }
        return maxOnes;
    }
}