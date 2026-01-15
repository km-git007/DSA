class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, maxSum = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if(j - i + 1 == k) {
                if(map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                sum -= nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return maxSum;
    }
}