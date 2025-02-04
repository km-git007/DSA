class Solution {
    public long maximumSubarraySum(int[] nums, int k) 
    {
        int i = 0;
        long sum = 0, maxSum = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int j = 0; j < nums.length; j++)
        {
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if(j - i + 1 == k)
            {
               if(map.size() == k)
               maxSum = Math.max(sum, maxSum);

               sum -= nums[i];

               // remove 1 occurance the ith number from the map
               map.put(nums[i], map.get(nums[i]) - 1);

                // if no more occurance of the its number is left than remove it from the map
                if(map.get(nums[i]) == 0)
                map.remove(nums[i]);

                i++;
            }
        }
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}