class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(num));
        }

        map.clear();
        int i = 0, minLength = nums.length;
        for(int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.get(nums[j]) == maxFrequency) {
                minLength = Math.min(minLength, j - i + 1);
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
        }
        return minLength;
    }
}