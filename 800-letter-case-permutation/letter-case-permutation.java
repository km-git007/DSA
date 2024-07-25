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

        // Append the current character and proceed
        sb.append(c);
        solve(index+1,s);
        sb.deleteCharAt(sb.length()-1);

        // Toggle case if the character is alphabetic
        if (Character.isLetter(c)) 
        {
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
            solve(index + 1, s);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCasePermutation(String s) 
    {
        solve(0,s);
        return permutations;
    }
}