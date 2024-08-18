class Solution {
    public int countKConstraintSubstrings(String s, int k) 
    {
        int zeroes=0,ones=0;
        int i=0,count=0;
        for(int j=0;j<s.length();j++)
        {
            char c=s.charAt(j);
            if(c=='0')
            zeroes++;
            else
            ones++;

            // substrings ending on jth index
            while(zeroes>k && ones>k)
            {
                char c1=s.charAt(i);
                if(c1=='0')
                zeroes--;
                else
                ones--;

                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}