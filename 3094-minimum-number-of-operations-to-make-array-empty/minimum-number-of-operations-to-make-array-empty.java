class Solution {
    public int minOperations(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count frequency of each number
        for(int num : nums) 
        map.put(num, map.getOrDefault(num, 0) + 1);

        int rounds = 0;
        // Process each unique difficulty level
        for (int freq : map.values()) {
            // If there's only 1 occurrence of a number, it's impossible to complete
            if (freq == 1) {
                return -1;
            }

            // If freq is divisible by 3, use only 3-task rounds
            if (freq % 3 == 0) {
                rounds += freq / 3;
            } 
            // Otherwise, take as many 3-task rounds as possible and one 2-task round
            else {
                rounds += (freq / 3) + 1;
            }
        }

        return rounds;
    }
}