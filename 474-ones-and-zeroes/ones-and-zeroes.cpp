class Solution {
public:

    int findMaxForm(vector<string>& s, int m, int n) 
    {
        int dp[m+1][n+1][s.size()+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                for(int k=0;k<s.size()+1;k++)
                {
                    if(k==0)
                        dp[i][j][k]=0;
                    else
                    {
                        string str=s[k-1];
                        int zeroes=count(str.begin(),str.end(),'0');
                        int ones=str.length()-zeroes;

                        if(i>=zeroes and j>=ones)
                        dp[i][j][k]=max(1+dp[i-zeroes][j-ones][k-1],dp[i][j][k-1]);

                        else
                        dp[i][j][k]=dp[i][j][k-1];
                    } 
                }
            }
        }
        return dp[m][n][s.size()];
    }

};