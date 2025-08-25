class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] numPeople = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--){
            int count = 0;
            while(!stack.isEmpty() && stack.peek() < heights[i]){
                stack.pop();
                count++;
            }

            numPeople[i] = stack.isEmpty() ? count : count + 1;

            stack.push(heights[i]);
        }
        return numPeople;
    }
}