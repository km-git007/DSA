class Solution {
    private boolean check(char ch, Deque<Character> stack)
    {
        return Math.abs(ch - stack.peek()) == 32;
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