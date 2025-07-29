class Solution {
    public int[] canSeePersonsCount(int[] heights) 
    {
        int[] canSeePersonsCount = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = heights.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && stack.peek() < heights[i]){
                stack.pop();
                canSeePersonsCount[i]++;
            }
            // if stack isn't empty then though the current minion is
            // smaller than that at the top of the stack but, it can still see it.
            if(!stack.isEmpty()){
                canSeePersonsCount[i]++;
            }
            
            stack.push(heights[i]);
        }
        return canSeePersonsCount;
    }
}