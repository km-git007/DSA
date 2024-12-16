class Solution {
    private class Node 
    {
        Node next, prev;
        int num;
        Node(int num)
        {
            this.num = num;
        }
    }

    private Node buildCircularLinkedList(int n)
    {
        int number = 2;
        Node head = new Node(1);
        Node curr = head;
        while(number <= n)
        {
            Node node = new Node(number);
            curr.next = node;
            node.prev = curr;
            curr = node;
            number++;
        }
        curr.next = head;
        head.prev = curr;

        return head;
    }

    public int findTheWinner(int n, int k) 
    {
        Node head = buildCircularLinkedList(n);
        Node curr = head;
        while(curr.next != curr)
        {
            int count = k - 1;
            while(count > 0)
            {
                curr = curr.next;
                count--;
            }
            // remove the connection
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr = curr.next;
        }
        return curr.num;
    }
}