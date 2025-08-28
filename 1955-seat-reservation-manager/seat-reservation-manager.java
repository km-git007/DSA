class SeatManager {

    private boolean[] seats;
    private Queue<Integer> availableSeats;
    public SeatManager(int n) {
        seats = new boolean[n + 1];
        Arrays.fill(seats, true);
        availableSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 1; i < seats.length; i++) {
            availableSeats.add(i);
        }
    }

    public int reserve() {
        while(!availableSeats.isEmpty()){
            int index = availableSeats.poll();
            if(seats[index]){
                seats[index] = false;
                return index;
            }
        }
        // control won't reach here
        return -1;
    }

    public void unreserve(int seatNumber) {
        seats[seatNumber] = true;
        availableSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */