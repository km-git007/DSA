class Solution {
    private HashMap<String,Integer> map;
    private int solve(int[] nums, int target, int index)
    {
        if(index == nums.length)
        {
            if(target == 0)
            return 1;

            return 0;
        }

        String key = Integer.toString(target) + "_" + Integer.toString(index);
        if(map.containsKey(key))
        return map.get(key);

        int plus = solve(nums, target - nums[index], index + 1);
        int minus = solve(nums, target + nums[index], index + 1);

        map.put(key, plus + minus);
        return  plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) 
    {
        map = new HashMap<>();
        return solve(nums, target, 0);
    }
}