class Solution {
    public int minAddToMakeValid(String s) 
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray())
        {
            if(c=='(')
            stack.addLast(c);
            else
            {
                if(!stack.isEmpty() && stack.peekLast()=='(')
                stack.removeLast();
                else
                stack.addLast(c);
            }
        }
        return stack.size();
    }
}