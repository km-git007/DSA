class Solution {
    public String removeDuplicateLetters(String s) 
    {
        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];

        for(int i = 0; i < s.length(); i++)
        lastIndex[s.charAt(i) - 'a'] = i;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) 
        {
            // Get the current character
            char ch = s.charAt(i);

            if(taken[ch - 'a'])
            continue;
            
            // Check if the stack is not empty and if the currChar is less than top 
            // and topChar is present afterwards
            while(!stack.isEmpty() && ch - 'a' < stack.peek() && lastIndex[stack.peek()] > i) 
            taken[stack.pop()] = false;
            
            // Push curr char
            stack.push(ch - 'a'); 
            taken[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        sb.append((char)(stack.pop() + 'a'));
        
        return sb.reverse().toString();
    }
}