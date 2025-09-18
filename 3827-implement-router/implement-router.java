class Packet{
    int source, destination, timeStamp;
    public Packet(int source, int destination, int timeStamp) {
        this.source = source;
        this.destination = destination;
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return  true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Packet that = (Packet) o;
        return this.source == that.source && this.destination == that.destination  && 
                this.timeStamp == that.timeStamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timeStamp);
    }
}



class Router {
    private final int MEMORY_LIMIT;
    private Set<Packet> set;
    private Deque<Packet> deque;
    private Map<Integer, List<Integer>> map;
    public Router(int memoryLimit) {
        deque = new ArrayDeque<>();
        map = new HashMap<>();
        MEMORY_LIMIT = memoryLimit;
        set = new HashSet<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if(set.contains(packet)) {
            return false;
        }

        if(set.size() == MEMORY_LIMIT) {
            forwardPacket();
        }

        set.add(packet);
        deque.addLast(packet);

        // keep timestamps sorted (insertion order ensures it)
        map.putIfAbsent(destination, new ArrayList<>());
        map.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if(deque.isEmpty()) {
            return new int[0];
        }

        Packet packet = deque.pollFirst();
        // Remove the forwarded packet's timestamp from the set
        set.remove(packet);

        List<Integer> list = map.get(packet.destination);
        // remove one occurrence of this timestamp
        list.remove(0); 
        if (list.isEmpty()) {
            map.remove(packet.destination);
        }
        return new int[]{packet.source, packet.destination, packet.timeStamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = map.get(destination);
        if(list == null || list.isEmpty()) {
            return 0;
        }

        int[] indexes = getIndexes(list, startTime, endTime);
        if(indexes == null){
            return 0;
        }
        return indexes[1] - indexes[0] + 1;       
    }
    
    private int[] getIndexes(List<Integer> list, int startTime, int endTime) {
        int start = 0, end = list.size() - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) < startTime) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        if(start >= list.size()) {
            return null;
        }
        
        int res = start;
        end = list.size() - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) > endTime) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return new int[]{res, end};
    }
}