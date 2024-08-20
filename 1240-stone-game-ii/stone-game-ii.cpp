class Solution {
public:

    int dp[100][100][2];
    int maxAliceScore(vector<int>& piles,int canAlicePick,int m,int index)
    {
        if(index>=piles.size())
        return 0;

        if(dp[index][m][canAlicePick]!=-1)
        return dp[index][m][canAlicePick];

        int Score = canAlicePick ? 0 : INT_MAX;  // Start with 0 for maximization, INT_MAX for minimization
        int stones=0;
        for(int x=1;x<=2*m && index+x-1<piles.size();x++)
        {
            stones+=piles[index+x-1];
            if(canAlicePick)
            {
                int currScore=stones+maxAliceScore(piles,0,max(x,m),index+x);
                Score=max(Score,currScore);
            }
            else
            {
                int currScore=maxAliceScore(piles,1,max(x,m),index+x);
                Score=min(Score,currScore);
            }
        }
        return dp[index][m][canAlicePick]=Score;
    }

    int stoneGameII(vector<int>& piles) 
    {
        memset(dp,-1,sizeof(dp));
        return maxAliceScore(piles,1,1,0);
    }
};