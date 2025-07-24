class Solution {
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int [] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
            if(j - i + 1 == k) {
                result[i] = deque.peekFirst();
                if(deque.peekFirst() == nums[i]) {
                    deque.pollFirst();
                }
                i++;
            }
        }
        return result;
    }
}