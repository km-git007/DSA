class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String op : operations) {
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(second + first);
            }else {
                stack.push(Integer.valueOf(op));
            }
        }

        int score = 0;
        while(!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }
}