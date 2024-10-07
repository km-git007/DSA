
class LFUCache {

    // Node
    private class Node 
    {
        int key;
        int val;
        int freq;
        Node prev,next;
        public Node(int key, int val) 
        {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private class DLL
    {
        // We build Doubly LinkedList between the head and tail nodes.
        Node head,tail;
        int size;

        DLL()
        {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node)
        {
            node.next =  head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node)
        {
            node.prev.next = node.next;
            node.next.prev= node.prev;
            size--;
        }
    }

    // HashMap<key,Node> --> To Fetch the DLL in O(1) time.
    private HashMap<Integer, DLL> freqMap;

    // HashMap<key,Node> --> To Fetch the Node in O(1) time.
    private HashMap<Integer, Node> map;

    // Max capacity of our cache.
    private final int MAX_CAPACITY;

    // current size stores the value of current size of the LFU cache and minFreq stores the value of minimum 
    // requency of an element present in the LFU cache
    private int currSize, minFreq;

    public LFUCache(int capacity) 
    {
        freqMap = new HashMap<>();
        map = new HashMap<>();
        MAX_CAPACITY = capacity;
        currSize = 0;
        minFreq = 0;
    }
    
    // removes node from one DLL corresponding to frequency 'f' and puts it the the DLL corresponding 
    // to frequency 'f1', where (f1 = f + 1).
    private void update(Node node)
    {
        System.out.println("UPDATE "+node.key);

        // System.out.println("UPDATE "+node.freq);

        DLL savedList = freqMap.get(node.freq);

        savedList.remove(node);

        if(node.freq == minFreq && savedList.size==0)
        {
            minFreq++;
            freqMap.remove(node.freq);
        }

        node.freq++;

        DLL list = freqMap.getOrDefault(node.freq, new DLL());
        list.add(node);
        freqMap.put(node.freq, list);
    }


    public int get(int key) 
    {
        System.out.println("GET "+ key);

        if(!map.containsKey(key))
        return -1;

        Node node = map.get(key);
        update(node);

        return node.val; 
    }
    

    public void put(int key, int value) 
    {
        // This key already exists. Then 'put' becomes an update operation
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            update(node);
            System.out.println("PUT-if " +key+" "+value);
        }

        // Key DNE. currSize is less than the cache's MAX_CAPACITY.
        // This becomes a simple 'put' operation.
        else if(currSize<MAX_CAPACITY)
        {
            // create node
            Node node = new Node(key,value);
            // add node to the map.
            map.put(key,node);
            // add node in the DLL
            DLL list = freqMap.getOrDefault(1,new DLL());
            list.add(node);

            freqMap.put(1,list);
            // increase the size by 1;
            currSize++;
            // minFreq becomes '1'.
            System.out.println("CURR_SIZE "+currSize+" MAXCAP "+MAX_CAPACITY);

            minFreq = 1;
            System.out.println("PUT-else-if " + key+" "+value);
        }

        // Key DNE. currSize is equal the cache's MAX_CAPACITY.
        // Not a simple 'put' operation. LFU element should be deleted before insertion.
        else
        {
            // fetch the list having the least frequency.
            DLL savedList = freqMap.get(minFreq);

            // get hold of the node to be deleted
            // the last node of the list just before tail is our target node which has to deleted;
            Node nodeToDelete = savedList.tail.prev;

            // remove the node from the DLL
            savedList.remove(nodeToDelete);

            // remove the node from the map
            map.remove(nodeToDelete.key);

            // decrease the currSize of the LFU cache and call the put method again.
            currSize--;
            put(key,value);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */