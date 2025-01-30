class Solution {
    public int[] dailyTemperatures(int[] temp) 
    {
        int N = temp.length;
        int[] res = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = N - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && temp[i] >= temp[stack.peek()]) 
            stack.pop();

            if(stack.isEmpty())
            res[i] = 0;

            else
            res[i] = stack.peek() - i;

            stack.push(i);
        }
        return res;
    }
}