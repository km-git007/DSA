
class Solution {
public:
    int countKConstraintSubstrings(string s, int k) 
    {
        int zeroes=0,ones=0;
        int i=0,count=0;
        for(int j=0;j<s.length();j++)
        {
            if(s[j]=='0')
            zeroes++;
            else
            ones++;

            // if the substring fails the eligibility criteria we start removing characters from start of the
            // substring i.e we start incrementing 'i'.
            while(zeroes>k && ones>k)
            {
                if(s[i]=='0')
                zeroes--;
                else
                ones--;

                i++;
            }
            // count substrings starting with i'th and ending on j'th index.
            count+=j-i+1;
        }
        return count;
    }
};
