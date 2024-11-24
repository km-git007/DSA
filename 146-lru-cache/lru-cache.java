class LRUCache {

        // Doubly LinkedList
    private class Node
    {
        int key;
        int value;
        Node prev,next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    // We build LinkedList between the head and tail nodes.
    private final Node head,tail;

    // Max capacity of our cache.
    private final int MAX_CAPACITY;

    // HashMap<key,Node> --> To Fetch the Node in O(1) time.
    private HashMap<Integer, Node> cache;

    public LRUCache(int maxCapacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        MAX_CAPACITY = maxCapacity;
    }

    
      private void insertAtHead(Node node)
    {
        // add after the head
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        cache.put(node.key, node);
    }

    private void remove(Node node)
    {
        // remove the node just before the tail
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cache.remove(node.key);
    }

    public int get(int key)
    {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            remove(node);
            node.value = value;
            insertAtHead(node);
            return;
        }

        if(cache.size() == MAX_CAPACITY) {
            remove(tail.prev);
        }

        Node newNode = new Node(key, value);
        insertAtHead(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */