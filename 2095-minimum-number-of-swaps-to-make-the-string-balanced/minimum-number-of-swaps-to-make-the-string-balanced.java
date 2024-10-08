class Solution {
    public int minSwaps(String s) 
    {
        int open = 0;
        for(char c : s.toCharArray())
        {
            if(c == '[')
            open++;
            else if(open > 0)
            open--;
        }
        return (1+open)/2;
    }
}