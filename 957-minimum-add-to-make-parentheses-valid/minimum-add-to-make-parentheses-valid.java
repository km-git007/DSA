class Solution {
    public int minAddToMakeValid(String s) 
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray())
        {
            if(!stack.isEmpty() && c==')' && stack.peekLast()=='(')
            stack.removeLast();
            else
            stack.addLast(c);
        }
        return stack.size();
    }
}