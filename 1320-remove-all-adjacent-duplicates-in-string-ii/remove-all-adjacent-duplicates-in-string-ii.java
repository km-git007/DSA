class Solution {
    public String removeDuplicates(String s, int k) 
    {
        // stack {char, freq}
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(!stack.isEmpty() && s.charAt(i) - 'a' == stack.peek()[0])
            stack.peek()[1]++;

            else
            stack.push(new int[]{s.charAt(i) - 'a', 1});

            if(!stack.isEmpty() && stack.peek()[1] == k)
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            int ch = stack.peek()[0];
            int freq = stack.poll()[1];

            while(freq > 0)
            {
                sb.append((char)(ch + 'a'));
                freq--;
            }
        }

        return sb.reverse().toString();
    }
}