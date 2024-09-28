class MyCircularDeque {

    private class Node
    {
        int val;
        Node next,prev;
        Node(int val)
        {
            this.val=val;
            next=prev=null;
        }
    }

    public MyCircularDeque(int k)
    {
        size=0;
        MAX_CAPACITY=k;
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }

    private Node head,tail;
    private final int MAX_CAPACITY;
    private int size;
    public boolean insertFront(int value)
    {
        if(isFull())
        return false;

        Node node=new Node(value);
        
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
        size++;
        return true;
    }

    public boolean insertLast(int value)
    {
        if(isFull())
        return false;

        Node node=new Node(value);
        
        node.next=tail;
        node.prev=tail.prev;
        tail.prev.next=node;
        tail.prev=node;
        size++;
        return true;
    }

    public boolean deleteFront() 
    {
        if(size==0)
        return false;

        head.next.next.prev=head;
        head.next=head.next.next;
        size--;
        return true;
    }

    public boolean deleteLast() 
    {
        if(size==0)
        return false;

        tail.prev.prev.next=tail;
        tail.prev=tail.prev.prev;
        size--;
        return true;
    }

    public int getFront()
    {
        if(isEmpty())
        return -1;
        return head.next.val;
    }

    public int getRear()
    {
        if(isEmpty())
        return -1;
        return tail.prev.val;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean isFull()
    {
        return size==MAX_CAPACITY;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */