class Solution {
public:
    int solveRec(int i,int j,string &s1,string &s2){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(s1[i] == s2[j])
         return solveRec(i-1,j-1,s1,s2);

         return 1+min(solveRec(i,j-1,s1,s2),min(solveRec(i-1,j,s1,s2),solveRec(i-1,j-1,s1,s2)));
    }

    int solveMemo(int i,int j,string &s1,string &s2, vector<vector<int>>& dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j])
         return dp[i][j] = solveMemo(i-1,j-1,s1,s2,dp);

         return  dp[i][j]=1+min(solveMemo(i,j-1,s1,s2,dp),min(solveMemo(i-1,j,s1,s2,dp),solveMemo(i-1,j-1,s1,s2,dp)));
    }
    int minDistance(string s1, string s2) {
        int n = s1.size();
        int m = s2.size();
        vector<vector<int>> dp(n+1,vector<int> (m+1,-1));

        //int ans = solveRec(n-1,m-1,s1,s2);
        int ans = solveMemo(n-1,m-1,s1,s2,dp);
        return ans;
    }
};