class Solution {
public:
    bool isPallindrome(string &s,int i,int j)
    {
        while(i<=j)
        {
            if(s[i]!=s[j])
            return false;

            i++;
            j--;
        }
        return true;
    }

    string longestPalindrome(string s) 
    {
        int n=s.length();
        int maxLength=1,startIndex=-1;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(isPallindrome(s,i,j))
                {
                    if(j-i+1>=maxLength)
                    {
                        maxLength=j-i+1;
                        startIndex=i;
                    }
                }
            }
        }
        return s.substr(startIndex,maxLength);
    }
};