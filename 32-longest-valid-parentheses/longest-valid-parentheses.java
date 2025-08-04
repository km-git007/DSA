class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }
                maxLength = Math.max(maxLength, i - stack.peek());
            }
        }
        return maxLength;
    }
}