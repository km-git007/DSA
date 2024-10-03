
class LRUCache {

    // Doubly Linked List node
    class Node
    {
    public:
        int key;
        int value;
        Node* prev;
        Node* next;
        // Constructor to initialize a node
        Node(int k, int v) : key(k), value(v), prev(nullptr), next(nullptr) {}
    };

    // Head and tail of the doubly linked list
    Node* head;
    Node* tail;

    // Maximum capacity of the cache
    const int MAX_CAPACITY;

    // HashMap to store key-Node pairs for O(1) access
    unordered_map<int, Node*> cache;

public:
    // Constructor to initialize LRUCache with a given capacity
    LRUCache(int capacity) : MAX_CAPACITY(capacity) {
        head = new Node(0, 0);  // Dummy head node
        tail = new Node(0, 0);  // Dummy tail node
        head->next = tail;      // Connect head and tail
        tail->prev = head;
    }

    // Insert a node at the head of the list (most recently used)
    void insert(int key, int value) {
        Node* newNode = new Node(key, value);
        newNode->next = head->next;
        newNode->prev = head;
        head->next->prev = newNode;
        head->next = newNode;
        cache[key] = newNode;  // Store key-Node pair in cache
    }

    // Remove a node from the list
    void remove(Node* node) {
        node->prev->next = node->next;
        node->next->prev = node->prev;
        cache.erase(node->key);  // Remove the key from cache
        delete node;  // Free the node's memory
    }

    // Get the value of the key if the key exists in the cache
    int get(int key) {
        if (!cache.count(key)) return -1;  // Key doesn't exist
        Node* node = cache[key];           // Get the node
        int value = node->value;

        // Remove the node from its current position and re-insert it at the head
        remove(node);
        insert(key, value);

        return value;
    }

    // Put a new key-value pair in the cache
    void put(int key, int value) {
        // If key already exists, remove the old node
        if (cache.count(key)) {
            remove(cache[key]);
        }
        // If the cache is full, remove the least recently used (LRU) node
        if (cache.size() == MAX_CAPACITY) {
            remove(tail->prev);  // Tail's previous node is the LRU node
        }
        // Insert the new node at the head of the list
        insert(key, value);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */