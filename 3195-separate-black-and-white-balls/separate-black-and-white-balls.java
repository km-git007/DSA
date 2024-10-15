class Solution {

    public long minimumSteps(String s) 
    {
        int n = s.length();
        long blackCount = 0;
        long swaps = 0;
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c == '1')
            blackCount++;
            else
            swaps+=blackCount;
        }
        return swaps;
    }
}