class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        Deque<Integer> stack = new ArrayDeque<>();
        int []res = new int[nums.length];
        for(int i = 2 * nums.length - 1; i >= 0; i--)
        {
            int index = i % nums.length;
            while(!stack.isEmpty() && nums[index] >= stack.peek())
            stack.pop();

            if(stack.isEmpty())
            res[index] = -1;

            else
            res[index] = stack.peek();

            stack.push(nums[index]);
        }
        return res;
    }
}