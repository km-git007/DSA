class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) 
    {
        // Longest common Substring
        int n=nums1.size();
        int m=nums2.size();
        int maxLen=0;
        vector<int> prev(m+1,0);
        vector<int> curr(m+1,0);
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(nums1[i-1]==nums2[j-1])
                curr[j]=1+prev[j-1];
                
                else
                curr[j]=0;

                maxLen=max(curr[j],maxLen);
            }
            prev=curr;
        }
        return maxLen;
    }
};