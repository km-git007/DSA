class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) 
    {
        int n = mat.size(), m = mat[0].size();
        vector<vector<int>> dp(n, vector<int>(m, 0));
        for(int i = 0; i < n; i++)
        {
            for(int j  = m - 1; j >= 0; j--)
            {
                if(!mat[i][j])
                continue;

                dp[i][j] = 1 + (j + 1 < m ? dp[i][j+ 1] : 0); 
            }
        } 

        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j  = 0; j < m; j++)
            {
                if(!mat[i][j])
                continue;

                int minWidth = m;
                for(int k = i; k < n; k++)
                {
                    minWidth = min(minWidth, dp[k][j]);
                    count += minWidth;
                }
            }
        }  
        return count;  
    }
};