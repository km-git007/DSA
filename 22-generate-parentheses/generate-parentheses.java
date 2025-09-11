class Solution {
    private void generate(int open, int closed, StringBuilder sb, List<String> res){
        if(closed == 0){
            res.add(sb.toString());
            return;
        }
        
        if(open < 0){
            return;
        }
        
        sb.append('(');
        generate(open - 1, closed, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        
        if(open < closed){
            sb.append(')');
            generate(open, closed - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, n, new StringBuilder(), res);
        return res;
    }
}