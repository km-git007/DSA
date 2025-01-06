class MedianFinder {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    public MedianFinder() 
    {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) 
    {
        // Add to maxHeap first
        maxHeap.add(num);

        // Ensure the smallest element of maxHeap is moved to minHeap
        minHeap.add(maxHeap.poll());

        // Balance sizes: maxHeap can only have at most one more element than minHeap
        if(maxHeap.size() < minHeap.size()) 
        maxHeap.add(minHeap.poll());
        
    }
    
    public double findMedian() 
    {
        // If heaps are the same size, the median is the average of the tops of both heaps
        if(maxHeap.size() == minHeap.size()) 
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
        
        // Otherwise, the median is the top of the maxHeap
        return (double)maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */