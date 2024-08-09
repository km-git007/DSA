class Solution {
public:

    int dp[1001][1001];
    int isPallindrome(string &s,int i,int j)
    {
        if(dp[i][j]!=-1)
        return dp[i][j];

        int start=i,end=j;
        while(start<=end)
        {
            if(s[start]!=s[end])
            return dp[i][j]=0;

            start++;
            end--;
        }
        return dp[i][j]=1;
    }

    string longestPalindrome(string s) 
    {
        int n=s.length();
        memset(dp,-1,sizeof(dp));
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