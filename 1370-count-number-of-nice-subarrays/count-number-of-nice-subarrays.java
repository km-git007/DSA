class Solution {
    private int atLeastKNiceSubarrays(int[] nums, int k) {
        int count = 0, oddCount = 0, i = 0;
        for(int j = 0; j < nums.length; j++){
            oddCount += nums[j] % 2 == 0 ? 0 : 1;
            while(oddCount >= k){
                count += nums.length - j;
                oddCount -= nums[i] % 2 == 0 ? 0 : 1;
                i++;
            }
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atLeastKNiceSubarrays(nums, k) - atLeastKNiceSubarrays(nums, k + 1);
    }
}