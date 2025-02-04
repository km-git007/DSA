class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        int pSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++)
        {
            pSum += nums[i];

            if(map.containsKey(pSum - goal))
            count += map.get(pSum - goal);

            map.put(pSum, map.getOrDefault(pSum, 0) + 1);
        }
        return count;
    }
}