class MyLinkedList {

    private class Node {

        int val;
        Node next;
        Node(int val)
        {
            this.val=val;
            next=null;
        }
    }

    private int length=0;
    private Node head;
    private Node tail;

    public MyLinkedList(){}
    
    public int get(int index) 
    {
        if(index>=length)
        return -1;

        Node curr=head;
        for(int i=0;i<index;i++)
        curr=curr.next;

        return curr.val;
    }
    
    public void addAtHead(int val) 
    {
        Node node=new Node(val);
        if(length==0)
        {
            head=tail=node;
            length++;
            return;
        }
        node.next=head;
        head=node;
        length++;
    }
    
    public void addAtTail(int val) 
    {
        Node node=new Node(val);
        if(length==0)
        {
            head=tail=node;
            length++;
            return;
        }
        tail.next=node;
        tail=node;
        length++;
    }
    
    public void addAtIndex(int index, int val) 
    {
        if(index>length)
        return;

        if(index==0)
        {
            addAtHead(val);
            return;
        }

        Node curr=head;
        for(int i=0;i<index-1;i++)
        curr=curr.next;

        Node node=new Node(val);
        node.next=curr.next;
        curr.next=node;

        // update tail for addition at the last index.
        if(index==length)
        tail=node;
        
        length++;
    }
    
    public void deleteAtIndex(int index) 
    {
        if(index>=length)
        return;

        if(index==0)
        {
            head=head.next;
            length--;

            // if we deleted the only existing node.
            if(length==0)
            tail=null;
            return;
        }

        Node curr=head;
        for(int i=0;i<index-1;i++)
        curr=curr.next;

        curr.next=curr.next.next;
        length--;

        // if deletion has taken place at the last index.
        if(length==index)
        tail=curr;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */