class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Set to count distinct elements in the entire array
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int i = 0;

        for (int j = 0; j < n; j++) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);

            while (freqMap.size() == unique.size()) {
                // all subarrays starting at i and ending at j...n-1 are valid
                count += n - j;

                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                if (freqMap.get(nums[i]) == 0) {
                    freqMap.remove(nums[i]);
                }
                i++;
            }
        }

        return count;
    }
}
