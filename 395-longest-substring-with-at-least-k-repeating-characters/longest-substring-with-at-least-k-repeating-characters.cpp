class Solution {
public:
    int solve(string &s,int k,int low,int high)
    {
        if(low>high || high-low+1<k)
        return 0;

        int map[26]={0};
        for(int i=low;i<=high;i++)
        map[s[i]-'a']++;

        for(int i=low;i<=high;i++)
        {
            int l1=0,l2=0;
            if(map[s[i]-'a']<k)
            {
                l1=solve(s,k,low,i-1);
                l2=solve(s,k,i+1,high);
                return max(l1,l2);
            }
        }
        return high-low+1;
    }

    int longestSubstring(string s, int k) 
    {
        return solve(s,k,0,s.length()-1);
    }
};