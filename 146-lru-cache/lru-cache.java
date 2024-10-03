
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
    
    public LRUCache(int capacity) 
    {
        MAX_CAPACITY = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    // Inserts at the head of the LinkedList and make the node most recently used
    private void insert(int key,int value)
    {
        Node newNode = new Node(key,value);
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        cache.put(key, newNode);
    }
    
    // Removes the LRU node from the tail.
    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cache.remove(node.key);
    }
    
    public int get(int key) 
    {
        // If the key is not present
        if(!cache.containsKey(key))  return -1;
        
        // If the key is found.
        Node node = cache.get(key);
        int value = node.value;
        
        // Remove the node from the LinkedList
        remove(node);
        // Make this node most recent.
        insert(node.key, node.value);
        return value;
    }

    public void put(int key, int value) 
    {
        // if the key to be inserted is already present.
        if(cache.containsKey(key))
        {
            // fetch the node corresponding to the key.
            Node nodeToRemove = cache.get(key);
            remove(nodeToRemove);
            insert(key,value);
            return;
        }
        
        // If the cache has reached its max capacity then delete the LRU node
        if(cache.size() == MAX_CAPACITY)
        remove(tail.prev);
        
        // Insert the node at the head and make it most recently used.
        insert(key,value);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */