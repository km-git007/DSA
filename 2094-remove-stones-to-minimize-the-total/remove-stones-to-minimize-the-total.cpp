class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) 
    {
        priority_queue<int,vector<int>> maxHeap(piles.begin(),piles.end());

        while(k)
        {
            int a=maxHeap.top();
            maxHeap.pop();

            a-=a/2;

            maxHeap.push(a);
            k--;
        }

        int sum=0;
        while(!maxHeap.empty())
        {
            sum+=maxHeap.top();
            maxHeap.pop();
        }
        return sum;
    }
};