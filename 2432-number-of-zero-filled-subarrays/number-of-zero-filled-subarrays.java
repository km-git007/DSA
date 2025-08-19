class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long subArrayLength = 1;
        int index = 0;
        while (index < nums.length){
            while(index < nums.length && nums[index] == 0){
                count += subArrayLength;
                subArrayLength++;
                index++;
            }
            subArrayLength = 1;
            index++;
        }
        return count;
    }
}