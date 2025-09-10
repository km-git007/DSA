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
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null){
            while(curr != null && curr.child == null){
                curr = curr.next;
            }

            if(curr == null)
            break;

            Node next = curr.next;
            Node ptr = curr.child;
            // make connections
            ptr.prev = curr;
            curr.next = ptr;
            curr.child = null;

            //find tail
            while(ptr.next != null){
                ptr = ptr.next;
            }

            // connect tail to the next node
            ptr.next = next;
            if(next != null){
                next.prev = ptr;
            }

            // mover forward
            curr = curr.next;
        }
        return head;
    }
}