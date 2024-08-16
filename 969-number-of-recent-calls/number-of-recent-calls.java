class RecentCounter {

    Queue<Integer> q=new LinkedList<>();
    int lowerLimit;
    private void maintainQueue(int t)
    {
        q.offer(t);
        lowerLimit=t-3000;
        while(q.peek()<lowerLimit)
        q.poll();
    }

    public RecentCounter() {}
    
    public int ping(int t) 
    {     
        maintainQueue(t);
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */