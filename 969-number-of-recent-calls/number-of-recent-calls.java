class RecentCounter {

    Queue<Integer> q=new LinkedList<>();
    int lowerLimit;
    private void maintainQueue()
    {
        while(q.peek()<lowerLimit)
        q.poll();
    }

    public RecentCounter() {}
    
    public int ping(int t) 
    {
        q.offer(t);
        lowerLimit=t-3000;
        maintainQueue();

        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */