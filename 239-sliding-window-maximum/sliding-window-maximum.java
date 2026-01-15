class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if(i - k + 1 >= 0) {
                result[i - k + 1] = deque.peekFirst();
                if(nums[i - k + 1] == deque.peekFirst()) {
                    deque.pollFirst();
                }
            }
        }
        return result;
    }
}