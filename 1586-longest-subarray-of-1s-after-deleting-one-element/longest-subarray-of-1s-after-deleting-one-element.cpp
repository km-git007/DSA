class Solution {
public:
    int longestSubarray(vector<int>& a) 
    {
        int zeroes=0,i=0;
        int maxLen=0;
        for(int j=0;j<a.size();j++)
        {
            if(a[j]==0)
            zeroes++;

            while(zeroes>1)
            {
                if(a[i]==0)
                zeroes--;
                i++;
            }
            maxLen=max(maxLen,j-i+1);
        }
        return maxLen-1;
    }
};