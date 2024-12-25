/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        Node curr = head;
        while(curr != null)
        {
            if(curr.child != null)
            {
                // find the tail in the child chain
                Node tail = curr.child;
                while(tail.next != null)
                tail =tail.next;

                // connect the tail to the curr.next
                if(curr.next != null)
                {
                    tail.next = curr.next;
                    curr.next.prev = tail;
                }

                // Connect the current node to its child
                curr.next = curr.child;
                curr.child.prev = curr;
                // Clear the child pointer
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}