class Solution {

    public boolean check(char c,StringBuilder s)
    {
        if(c==')' && s.charAt(s.length()-1)!='(')
        return false;
        else if(c=='}' && s.charAt(s.length()-1)!='{')
        return false;
        else if(c==']' && s.charAt(s.length()-1)!='[')
        return false;

        return true;
    } 

    public boolean isValid(String str) 
    {
        StringBuilder s=new StringBuilder("");
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[')
            s.append(str.charAt(i));
            else
            {
                if(s.isEmpty() || !check(str.charAt(i),s))
                return false;
                s.deleteCharAt(s.length()-1);
            }
        }
        return s.isEmpty();
    }
}