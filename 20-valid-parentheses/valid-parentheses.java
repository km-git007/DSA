class Solution {
    public boolean isValid(String s) 
    {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchingBrackets = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        for(char ch : s.toCharArray()) 
        {
            if(ch == '(' || ch == '[' || ch == '{')
            stack.push(ch);
            
            else 
            {
                if(stack.isEmpty() || stack.peek() != matchingBrackets.get(ch))
                return false;

                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}