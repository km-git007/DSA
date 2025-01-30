class Solution {
    private boolean check(char ch, Deque<Character> stack)
    {
        boolean case1 = Character.isLowerCase(ch) && (ch - 'a' == stack.peek() - 'A');
        boolean case2 = Character.isUpperCase(ch) && (ch - 'A' == stack.peek() - 'a');
        return case1 || case2;
    }

    public String makeGood(String s) 
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray())
        {
            if(!stack.isEmpty() && check(c, stack))
            stack.pop();
            else
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        sb.append(stack.pop());

        return sb.reverse().toString();
    }
}