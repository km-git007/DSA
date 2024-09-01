
class FrontMiddleBackQueue {
private:
    struct Node {
        int val;
        Node* next;
        Node* prev;

        Node(int val) {
            this->val = val;
            next = prev = nullptr;
        }
    };

    Node* head;
    Node* tail;
    Node* middle;
    int length;

public:
    FrontMiddleBackQueue() {
        head = new Node(-1);
        tail = new Node(-1);
        head->next = tail;
        tail->prev = head;
        middle = nullptr;
        length = 0;
    }

    void pushFront(int data) {
        Node* node = new Node(data);
        node->next = head->next;
        node->next->prev = node;
        head->next = node;
        node->prev = head;

        length++;

        if (length == 1)
            middle = node;
        else if (length % 2 == 0)
            middle = middle->prev;
    }

    void pushMiddle(int data) {
        if (length == 0) {
            pushFront(data);
            return;
        }

        Node* node = new Node(data);

        // Push right at the middle index
        if (length % 2 == 1) {
            node->next = middle;
            node->prev = middle->prev;
            middle->prev->next = node;
            middle->prev = node;

            // Update middle
            middle = middle->prev;
        } else { // Push just after the middle
            node->next = middle->next;
            middle->next->prev = node;
            middle->next = node;
            node->prev = middle;

            // Update middle
            middle = middle->next;
        }
        length++;
    }

    void pushBack(int data) {
        Node* node = new Node(data);
        node->next = tail;
        node->prev = tail->prev;
        tail->prev->next = node;
        tail->prev = node;

        length++;

        if (length == 1)
            middle = node;
        else if (length % 2 == 1)
            middle = middle->next;
    }

    int popFront() {
        if (length == 0)
            return -1;

        Node* frontNode = head->next;
        frontNode->next->prev = head;
        head->next = frontNode->next;
        length--;

        if (length % 2 == 1)
            middle = middle->next;

        if (length == 0)
            middle = nullptr;

        int val = frontNode->val;
        delete frontNode;
        return val;
    }

    int popMiddle() {
        if (length == 0)
            return -1;

        Node* newMiddle;
        if (length % 2 == 1)
            newMiddle = middle->prev;
        else
            newMiddle = middle->next;

        int middleNodeValue = middle->val;

        middle->prev->next = middle->next;
        middle->next->prev = middle->prev;
        length--;

        delete middle;
        middle = newMiddle;

        if (length == 0)
            middle = nullptr;

        return middleNodeValue;
    }

    int popBack() {
        if (length == 0)
            return -1;

        Node* backNode = tail->prev;
        backNode->prev->next = tail;
        tail->prev = backNode->prev;
        length--;

        if (length % 2 == 0)
            middle = middle->prev;

        if (length == 0)
            middle = nullptr;

        int val = backNode->val;
        delete backNode;
        return val;
    }
};


/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue* obj = new FrontMiddleBackQueue();
 * obj->pushFront(val);
 * obj->pushMiddle(val);
 * obj->pushBack(val);
 * int param_4 = obj->popFront();
 * int param_5 = obj->popMiddle();
 * int param_6 = obj->popBack();
 */