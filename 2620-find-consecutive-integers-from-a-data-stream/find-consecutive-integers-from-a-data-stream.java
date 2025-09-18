class DataStream {
    private Deque<Integer> deque;
    int counter, value, k;
    public DataStream(int value, int k) {
        deque = new ArrayDeque<>();
        counter = 0;
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if(deque.size() == k) {
            counter -= deque.pollFirst() == value ? 1 : 0;
        }
        
        // add to the deque
        deque.addLast(num);
        counter += num == value ? 1 : 0;
        
        return counter == k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */