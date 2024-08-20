class Solution {
public:

    int dp[50000][2];
    int maxAliceScore(vector<int>& stoneValue,int canAlicePick,int index)
    {
        if(index>=stoneValue.size())
        return 0;

        if(dp[index][canAlicePick]!=-1)
        return dp[index][canAlicePick];

        int Score = canAlicePick ? INT_MIN : INT_MAX;  // Start with 0 for maximization, INT_MAX for minimization
        int stones=0;
        for(int i=0;i<3 && index+i<stoneValue.size();i++)
        {
            stones+=stoneValue[index+i];
            if(canAlicePick)
            {
                int currScore=stones+maxAliceScore(stoneValue,0,index+i+1);
                Score=max(Score,currScore);
            }
            else
            {
                int currScore=maxAliceScore(stoneValue,1,index+i+1);
                Score=min(Score,currScore);
            }
        }
        return dp[index][canAlicePick]=Score;
    }

    string stoneGameIII(vector<int>& stoneValue) 
    {
        memset(dp,-1,sizeof(dp));
        int totalStones=accumulate(stoneValue.begin(),stoneValue.end(),0);
        int AliceScore=maxAliceScore(stoneValue,1,0);
        int BobScore=totalStones-AliceScore;

        if(AliceScore==BobScore)
        return "Tie";
        if(AliceScore>BobScore)
        return "Alice";
        return "Bob";
    }
};