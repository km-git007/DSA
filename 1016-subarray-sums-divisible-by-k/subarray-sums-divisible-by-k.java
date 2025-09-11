class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, count = 0;
        for (int j : nums) {
            prefixSum += j;
            int rem = prefixSum % k;
            if(rem < 0){
                rem += k;
            }
            if (map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}