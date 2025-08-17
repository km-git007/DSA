class Solution {
    private boolean isDepthNonZero(int depth){
        return depth > 0;
    }
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '(') {
                if(isDepthNonZero(depth)){
                    sb.append(c);
                }
                depth++;
            }else {
                depth--;
                if(isDepthNonZero(depth)){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}