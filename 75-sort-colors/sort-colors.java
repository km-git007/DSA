class Solution {
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(mid, high, nums);
                high--;
            }
            else{
                swap(low, mid, nums);
                low++;
                mid++;
            }
        }
    }
}