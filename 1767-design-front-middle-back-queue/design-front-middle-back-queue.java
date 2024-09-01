class FrontMiddleBackQueue {


    private class Node {

        int val;
        Node next,prev;
        public Node(int val)
        {
            this.val = val;
            prev=next=null;
        }
    }

    Node head,tail,middle;
    int length;

    public FrontMiddleBackQueue()
    {
        head=new Node(-1);
        tail=new Node(-1);
        head.next = tail;
        tail.prev = head;
        middle=null;
        length=0;
    }

    public void pushFront(int data)
    {
        Node node=new Node(data);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;

        length++;

        if(length==1)
            middle=node;

        else if(length%2==0)
            middle=middle.prev;
    }

    public void pushMiddle(int data)
    {
        if(length==0)
        {
            pushFront(data);
            return;
        }

        Node node=new Node(data);
        
        // push right at the middle index
        if(length%2==1)
        {
            node.next=middle;
            node.prev=middle.prev;
            middle.prev.next=node;
            middle.prev=node;

            // update middle
            middle=middle.prev;
        }
        // push just after the middle
        else
        {
            node.next=middle.next;
            middle.next.prev=node;
            middle.next=node;
            node.prev=middle;

            // update middle
            middle=middle.next;
        }
        length++;
    }

    public void pushBack(int data)
    {
        Node node=new Node(data);
        node.next=tail;
        node.prev=tail.prev;
        tail.prev.next=node;
        tail.prev=node;

        length++;

        if(length==1)
            middle=node;

        else if(length%2==1)
            middle=middle.next;
    }

    public int popFront()
    {
        if (length == 0)
            return -1;

        Node frontNode=head.next;
        frontNode.next.prev=head;
        head.next=frontNode.next;
        length--;

        if(length%2==1)
            middle=middle.next;

        if(length==0)
            middle=null;

        return frontNode.val;
    }

    public int popMiddle()
    {
        if (length == 0)
            return -1;

        Node newMiddle;
        if(length%2==1)
            newMiddle=middle.prev;
        else
            newMiddle=middle.next;

        int middleNodeValue=middle.val;

        middle.prev.next=middle.next;
        middle.next.prev=middle.prev;
        length--;

        middle=newMiddle;
        if(length==0)
            middle=null;

        return middleNodeValue;
    }

    public int popBack()
    {
        if (length == 0)
            return -1;

        Node backNode=tail.prev;
        backNode.prev.next=tail;
        tail.prev=backNode.prev;
        length--;

        if(length%2==0)
            middle=middle.prev;

        if(length==0)
            middle=null;

        return backNode.val;
    }
}
/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */