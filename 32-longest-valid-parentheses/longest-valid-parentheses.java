class Solution {
    public int longestValidParentheses(String s) 
    {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            stack.push(i);
            else
            {
                stack.pop();
                if(!stack.isEmpty())
                maxLength = Math.max(maxLength, i - stack.peek());
                else
                stack.push(i);
            }
        }
        return maxLength;
    }
}