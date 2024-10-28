class Solution {
    public int longestSquareStreak(int[] nums) 
    {
        int maxStreak = 1;
        Arrays.sort(nums);

        HashSet<Long> set = new HashSet<>();
        for(int num : nums)
        set.add((long)num);

        for(int i = 0; i < nums.length; i++)
        {
            int streak = 0;
            long num = nums[i];
            while(set.contains(num))
            {
                streak++;
                set.remove(num);
                // Why Remove? When num is found in the set, it is remove to prevent using it again in future 
                // iterations, thus avoiding redundant work. By erasing, we mark that element as already processed, 
                // saving time and ensuring we only count each number once in any streak.
                num = num * num;
            }
            maxStreak = Math.max(streak,maxStreak);
        }
        return maxStreak < 2 ? -1 : maxStreak;
    }

}