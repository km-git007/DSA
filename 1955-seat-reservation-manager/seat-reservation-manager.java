class SeatManager {

    private class Seat{

        int seatNumber;
        boolean isReserved;
        Seat(int seatNumber,boolean isReserved)
        {
            this.seatNumber=seatNumber;
            this.isReserved=isReserved;
        } 
    }
    
    PriorityQueue<Seat> queue=new PriorityQueue<>((a,b)->a.seatNumber-b.seatNumber);
    public SeatManager(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            Seat seat=new Seat(i,false);
            queue.offer(seat);
        }
    }
    
    public int reserve() 
    {
        Seat seat=queue.poll(); 
        seat.isReserved=true;
        return seat.seatNumber;
    }
    
    public void unreserve(int seatNumber) 
    {
        Seat seat=new Seat(seatNumber,false);
        queue.offer(seat);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */