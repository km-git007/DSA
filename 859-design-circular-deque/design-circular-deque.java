class MyCircularDeque {

    Node head,tail;
    int length,size;
    class Node{

        int val;
        Node next,prev;
        Node(int val){
            this.val=val;
            next=prev=null;
        }
    }

    public MyCircularDeque(int k){
        size=k;
        length=0;
    }

    public boolean insertFront(int value){
        if(isFull())
            return false;

        Node node=new Node(value);
        if(length==0) {
            head=tail=node;
            length++;
            return true;
        }

        node.next=head;
        head.prev=node;
        head=node;
        length++;
        return true;
    }

    public boolean insertLast(int value){
        if(isFull())
            return false;

        Node node=new Node(value);
        if(length==0) {
            head=tail=node;
            length++;
            return true;
        }

        tail.next=node;
        node.prev=tail;
        tail=node;
        length++;
        return true;
    }

    public boolean deleteFront() {
        if(head==null)
        return false;

        if(head.next==null){
            head=tail=null;
            length--;
            return true;
        }

        head=head.next;
        head.prev=null;
        length--;
        return true;
    }

    public boolean deleteLast() {
        if(tail==null)
        return false;

        if(tail.prev==null){
            head=tail=null;
            length--;
            return true;
        }
        tail=tail.prev;
        tail.next=null;
        length--;
        return true;
    }

    public int getFront(){
        if(isEmpty())
        return -1;
        return head.val;
    }

    public int getRear(){
        if(isEmpty())
        return -1;
        return tail.val;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public boolean isFull(){
        return length==size;
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