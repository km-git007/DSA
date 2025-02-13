class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int operations = 0;
        for(int a = 0; a < nums.length; a++) {
            queue.add((long)nums[a]);
        }
        while(queue.size() > 1 && queue.peek() < k) {
            long val1 = queue.remove();
            long val2 = queue.remove();
            queue.add((val1*2) + val2);
            operations = operations + 1;
        }
        return operations;
    }
}