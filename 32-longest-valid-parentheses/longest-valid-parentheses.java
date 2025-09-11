class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(!stack.isEmpty()){
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
                else{
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}