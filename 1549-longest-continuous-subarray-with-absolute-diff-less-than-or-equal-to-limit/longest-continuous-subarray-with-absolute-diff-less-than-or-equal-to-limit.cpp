class Solution {
public:
    int longestSubarray(vector<int>& a, int limit) 
    {
        priority_queue<pair<int,int>> maxHeap;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> minHeap;
        int maxLen=0,i=0;
        for(int j=0;j<a.size();j++)
        {
            maxHeap.push({a[j],j});
            minHeap.push({a[j],j});

            while(maxHeap.top().first-minHeap.top().first>limit)
            {
                i=min(maxHeap.top().second, minHeap.top().second)+1;
                // Remove elements from the heaps that are outside the current window
                while(maxHeap.top().second<i)
                maxHeap.pop();
                while(minHeap.top().second<i)
                minHeap.pop();
            }
            maxLen=max(maxLen,j-i+1);
        }
        return maxLen;
    }
};