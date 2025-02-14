class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for(int num : pushed)
        {
            stack.push(num);
            while(!stack.isEmpty() && popped[index] == stack.peek())
            {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}