class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int res = 0;
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) 
        {
            int j = i + 1;
            int k = n - 1;
            while (j < k) 
            {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) 
                {
                    minDiff = diff;
                    res = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
