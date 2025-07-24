class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] seen = new boolean[10001]; // Constraints: 0 <= nums[i] <= 10000
        int i = 0, score = 0, maxScore = 0;

        for (int j = 0; j < nums.length; j++) {
            while (seen[nums[j]]) {
                score -= nums[i];
                seen[nums[i]] = false;
                i++;
            }
            seen[nums[j]] = true;
            score += nums[j];
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
