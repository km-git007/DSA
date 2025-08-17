class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0, depth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;
            }else if(ch == ')'){
                depth--;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}