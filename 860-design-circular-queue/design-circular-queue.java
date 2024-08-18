class MyCircularQueue {

    private Node head,tail;
    private int currSize,capacity;
    private class Node{
        int val;
        Node next,prev;
        Node(int val){
            this.val=val;
            next=prev=null;
        }
    }

    public MyCircularQueue(int k) {
        capacity=k;
        currSize=0;
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;

        Node node=new Node(value);
        node.next=tail;
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;

        currSize++;
        return true;
    }
    
    public boolean deQueue(){
        if(isEmpty())
            return false;
        
        Node node=head.next;
        head.next=node.next;
        node.next.prev=head;
        node=null;

        currSize--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())  return -1;
        return head.next.val;
    }
    
    public int Rear() {
        if(isEmpty())  return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return currSize==0;
    }
    
    public boolean isFull() {
        return currSize==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */