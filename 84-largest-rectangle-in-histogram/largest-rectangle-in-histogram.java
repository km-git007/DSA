class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                // we try to expand the popped element to the left and right
                int curr = stack.pop();
                
                // prevSmaller element is either the top of the stack or -1
                int prevSmaller = stack.isEmpty() ? -1 : stack.peek();
                // since ith element popped the current element, then nextSmaller element is i
                int nextSmaller = i;
                int width = nextSmaller - prevSmaller - 1;
                maxArea = Math.max(maxArea, width * heights[curr]);
            }
            stack.push(i);
        }

        // for the elements still present in the stack
        while(!stack.isEmpty()){
            // nextSmaller element doesn't exist
            // so, expand the element from prevSmaller to end of the array
            int curr = stack.pop();
            int prevSmaller = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (heights.length - prevSmaller - 1) * heights[curr]);
        }
        return maxArea;
    }
}