class Solution {
    public int maxSubarrayLength(int[] nums, int k) 
    {
        int maxLength = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < nums.length; j++)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.get(nums[j]) > k)
            {
                // remove 1 occurance the ith number from the map
                map.put(nums[i], map.get(nums[i]) - 1);

                // if no more occurance of the its number is left than remove it from the map
                if(map.get(nums[i]) == 0)
                map.remove(nums[i]);

                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}