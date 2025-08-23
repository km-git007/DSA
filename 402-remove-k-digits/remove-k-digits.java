class Solution {
    public String removeKdigits(String num, int k) 
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() > ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        // if not able to remove all k-digits 
        // remove the digits from the top of stack coz its monotonic inscreasing
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        
        int index = 0;
        // remove the leading zeroes
        while(index < sb.length() && sb.charAt(index) == '0'){
            index++;
        }
        String result = sb.substring(index);
        return result.isEmpty() ? "0" : result;
    }
}