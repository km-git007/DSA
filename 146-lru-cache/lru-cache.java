class Node
{
    int key;
    int value;
    Node prev, next;
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}


public class LRUCache {

    private final int CAPACITY;

    // head and tail are the dummy nodes
    private final Node head, tail;

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

    private void removeConnection(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAtHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node; 
    }

    public int get(int key)
    {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        removeConnection(node);
        addAtHead(node);

        return node.value;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key)){
            Node existingNode = map.get(key);
            // update the value
            existingNode.value = value;
            removeConnection(existingNode);
            addAtHead(existingNode);
            return;
        }

        Node node = new Node(key, value);
        addAtHead(node);
        map.put(key, node);

        if(map.size() > CAPACITY){
            Node lruNode = tail.prev;
            removeConnection(lruNode);
            map.remove(lruNode.key);
        }
    }

}