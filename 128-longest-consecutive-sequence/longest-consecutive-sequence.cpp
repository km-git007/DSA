class Solution {
public:
    int longestConsecutive(vector<int>& a) 
    {
        int maxLen=0;
        unordered_set<int> s(a.begin(),a.end());
    
        for(int i=0;i<a.size();i++)
        {
            int curr=a[i];
            //check whether the current number is the starting of a sequence
            if(!s.count(curr-1))        
            {
                int length=0;
                while(s.count(curr)>0)
                {
                    s.erase(curr);
                    length++;
                    curr++;
                }
                maxLen=max(maxLen,length);
            }
        }
        return maxLen;
    }
};