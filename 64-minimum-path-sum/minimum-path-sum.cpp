class Solution {
public:

    int minPathSum(vector<vector<int>>& grid) 
    {
        int n=grid.size();
        int m=grid[0].size();

        vector<int> curr(m),prev(m);
        prev[0]=grid[0][0];

        for(int j=1;j<m;j++)
        prev[j]=prev[j-1]+grid[0][j];


        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(j==0)
                curr[j]=prev[j]+grid[i][j];
                else
                curr[j]=grid[i][j]+min(prev[j],curr[j-1]);
            }
            prev=curr;
        }
        return prev[m-1];
    }
};