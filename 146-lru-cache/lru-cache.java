class Node
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


public class LRUCache {

    private final int CAPACITY;

    // head and tail are the dummy nodes
    private final Node head,tail;

    // for O(1) lookup
    private Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.tail = new Node(-1,-1);
        this.head = new Node(-1,-1);
        this.tail.prev = this.head;
        this.head.next = this.tail;
        map = new HashMap<>();
    }

    private void addAtHead(Node node)
    {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;

        // put in the map
        map.put(node.key,node);
    }

    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // remove from the map
        map.remove(node.key);
    }

    public int get(int key)
    {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addAtHead(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        Node node = map.get(key);
        
        // Key is already present
        if(node != null){
            // update the value
            node.value = value;
            remove(node);
            addAtHead(node);
            return;
        }

        // Key is not present then create a node
        Node newNode = new Node(key, value);
        
        // Map is full so remove the tail node
        if(map.size() >= CAPACITY){
            remove(tail.prev);
        }
        // Map is not full
        addAtHead(newNode);
    }

}