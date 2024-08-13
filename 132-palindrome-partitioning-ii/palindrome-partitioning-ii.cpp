class Solution {
public:
    
    int dp1[2001][2001];
    bool isPalindrome(string& s, int start, int end)
    {
        if(start>=end)
        return true;

        if(dp1[start][end]!=-1)
        return dp1[start][end];

        if(s[start] != s[end]) 
        return dp1[start][end]=false;
            
        return dp1[start][end]=isPalindrome(s,start+1,end-1);
    }
    
    int partitions(string& s, int start, int end, vector<vector<int>>& dp)
    {
        if(start >= end) return dp[start][end] = 0; //it is already a palindrome
        
        if(dp[start][end] != -1) return dp[start][end];
        
        if(isPalindrome(s, start, end)) return dp[start][end] = 0; //it is already a palindrome why need to partition
        
        int ans = INT_MAX;
        
        for(int k = start; k < end; k++)
        {
            //before making call, we are checking that if the string after partioning is palindrome or not, if
			//not we. will not consider that case.
			if(isPalindrome(s, start, k))
			{ 
                int temp = 1 + partitions(s, start, k, dp) + partitions(s, k + 1, end, dp);

                ans = min(temp , ans);
            }
        }
        
        return dp[start][end] = ans;
    }
    
    int minCut(string s) 
    {
        vector<vector<int>> dp(s.size() + 1, vector<int>(s.size() + 1, -1));
        memset(dp1,-1,sizeof(dp1));
        return partitions(s, 0, s.size() - 1, dp);
    }
};