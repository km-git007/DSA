class Solution {
    
    List<String> res=new ArrayList<>();
    public static StringBuilder s=new StringBuilder();
    public void solve(int open,int closed) 
    {
        if(open<0)
        return;

        if(open==0 && closed==0)
        {
            res.add(s.toString());
            return;
        }

        s.append('(');
        solve(open-1,closed);
        s.deleteCharAt(s.length()-1);

        if(open<closed)
        {
            s.append(')');
            solve(open,closed-1);
            s.deleteCharAt(s.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) 
    {
        solve(n,n);
        return res;
    }
}