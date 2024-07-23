class Solution {

    private String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();
    private StringBuilder curr = new StringBuilder();
    private void helper(String digits,int index)
    {
        if(index==digits.length())
        {
            res.add(curr.toString());
            return;
        }

        int number=digits.charAt(index)-'0';
        String str=keypad[number];
        for(int i=0;i<str.length();i++)
        {
            curr.append(str.charAt(i));
            helper(digits,index+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()==0)
        return res;

        helper(digits,0);
        return res;
    }
}