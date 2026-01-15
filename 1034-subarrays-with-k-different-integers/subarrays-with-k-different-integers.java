class Solution {

    private int numSubarrayWithAtLeastKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, i = 0, count = 0;
        for(int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() >= k) {
                count += n - j;
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k)
    {
        return numSubarrayWithAtLeastKDistinct(nums, k) - numSubarrayWithAtLeastKDistinct(nums, k + 1);
    }
}