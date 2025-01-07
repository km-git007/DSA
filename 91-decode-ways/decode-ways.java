class Solution {
    public int numDecodings(String s) 
    {
        int n = s.length();
        // empty string can be decoded in one way
        int plusOne = 1;
        int plusTwo = -1, curr;
        for(int i = n - 1; i >= 0; i--)
        {
            if(s.charAt(i) == '0')
            curr = 0;
            else
            {
                curr = plusOne;

                if(i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) <= 26)
                curr += plusTwo;
            }
            plusTwo = plusOne;
            plusOne = curr;
        }
        return plusOne;
    }
}