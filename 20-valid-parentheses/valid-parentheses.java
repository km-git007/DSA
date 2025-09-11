class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchingBrackets = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!matchingBrackets.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty() || stack.peek() != matchingBrackets.get(ch)){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}