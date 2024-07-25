class Solution {

    List<String> permutations=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    private void solve(int index,String s)
    {
        if(index==s.length())
        {
            permutations.add(sb.toString());
            return;
        }

        char c=s.charAt(index);

        sb.append(c);
        solve(index+1,s);
        sb.deleteCharAt(sb.length()-1);

        char d=changeCase(c);
        int result=Character.compare(c,d);
        if(result!=0)
        {
            sb.append(d);
            solve(index+1,s);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private char changeCase(char c) 
    {
        if(Character.isUpperCase(c))
        return Character.toLowerCase(c);

        if (Character.isLowerCase(c)) 
        return Character.toUpperCase(c);

        return c; // Non-alphabetic characters remain unchanged
    }

    public List<String> letterCasePermutation(String s) 
    {
        solve(0,s);
        return permutations;
    }
}