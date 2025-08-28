class SeatManager {

    PriorityQueue<Integer> queue=new PriorityQueue<>();
    public SeatManager(int n) 
    {
        for(int i=1;i<=n;i++)
        queue.offer(i);
    }
    
    public int reserve() 
    {
        int seatNumber=queue.poll(); 
        return seatNumber;
    }
    
    public void unreserve(int seatNumber) 
    {
        queue.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */