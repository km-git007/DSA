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
    
    Seat[] seatArray;
    PriorityQueue<Seat> queue=new PriorityQueue<>((a,b)->a.seatNumber-b.seatNumber);
    public SeatManager(int n) 
    {
        seatArray=new Seat[n+1];
        for(int i=1;i<=n;i++)
        {
            Seat seat=new Seat(i,false);
            queue.add(seat);
            seatArray[i]=seat;
        }
    }
    
    public int reserve() 
    {
        Seat seat = queue.poll();
        if(seat.isReserved==false)
        {
            seat.isReserved=true;
            return seat.seatNumber;
        }

        while(queue.peek().isReserved!=false)
        queue.poll();

        queue.peek().isReserved=true;
        return queue.poll().seatNumber;
    }
    
    public void unreserve(int seatNumber) 
    {
        Seat seat=seatArray[seatNumber];
        seat.isReserved=false;
        queue.add(seat);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */