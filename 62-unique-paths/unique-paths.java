class Solution {



    public int uniquePaths(int n, int m) 
    {
        int curr[] = new int[m];
        int prev[] = new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0)
                curr[j]=1;
                else
                curr[j]=prev[j]+curr[j-1];
            }
            prev = curr;
        }
        return prev[m-1];
    }
}