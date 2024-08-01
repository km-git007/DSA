class KthLargest {

private: 
    int K;
    priority_queue<int,vector<int>,greater<>> minHeap;

public:
    KthLargest(int k, vector<int>& a) 
    {
        K=k;
        for(int ele : a)
        {
            minHeap.push(ele);
            if(minHeap.size()>k)
            minHeap.pop();
        }
    }
    
    int add(int val) 
    {
        minHeap.push(val);
        if(minHeap.size()>K)
        minHeap.pop();
        return minHeap.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */