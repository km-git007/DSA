class Solution {
public:
    int minOperations(vector<int>& nums, int k) 
    {
        // Creating a Min Heap (priority_queue with greater<int> for min-heap behavior)
        priority_queue<long long, vector<long long>, greater<>> pq;

        // Insert all elements into the Min Heap
        for(int num : nums) 
        pq.push((long long)num);

        int oper = 0;
        // Continue merging until the smallest element is at least 'k'
        while (pq.size() > 1) 
        {
            long long a = pq.top(); 
            pq.pop();

            long long b = pq.top(); 
            pq.pop();

            if(a >= k && b >= k) 
            break;

            long long c = a * 2 + b; // Merge rule
            pq.push(c);

            oper++;
        }
        return oper;
    }
};