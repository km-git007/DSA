class Solution {
    private boolean isValid(Deque<Character> stack, char ch) {
        if(ch == ')' && stack.peek() != '('){
            return false;
        }
        else if(ch == ']' && stack.peek() != '['){
            return false;
        }
        else if(ch == '}' && stack.peek() != '{'){
            return false;
        }
        
        stack.pop();
        return true;
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if(stack.isEmpty() || !isValid(stack, ch)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}