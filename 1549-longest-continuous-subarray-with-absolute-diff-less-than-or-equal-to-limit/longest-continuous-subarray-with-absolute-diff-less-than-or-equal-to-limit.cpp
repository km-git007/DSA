class Solution {
public:
    int longestSubarray(vector<int>& a, int limit) 
    {
        deque<int> minList,maxList;
        int maxLen=0,i=0;
        for(int j=0;j<a.size();j++)
        {
            while(!minList.empty() && a[j]<minList.back())
            minList.pop_back();
            minList.push_back(a[j]);

            while(!maxList.empty() && a[j]>maxList.back())
            maxList.pop_back();
            maxList.push_back(a[j]);

            while(maxList.front()-minList.front()>limit)
            {
                if(a[i]==maxList.front())
                maxList.pop_front();
                if(a[i]==minList.front())
                minList.pop_front();
                i++;
            }

            maxLen=max(maxLen,j-i+1);
        }
        return maxLen;
    }
};