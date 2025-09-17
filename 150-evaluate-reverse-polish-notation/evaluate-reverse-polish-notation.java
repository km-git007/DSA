class Solution {
    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private int getResult(int x, int y, String opr){
        return switch (opr) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> 0;
        };
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            if(isOperator(token)) {                
                int first = stack.pop();
                int second = stack.pop();
                stack.push(getResult(second, first, token));
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}