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
            if(curr.child != null){

                Node nextNode = curr.next;
                Node tail = curr.child;

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                while(tail.next != null){
                    tail = tail.next;
                }

                tail.next = nextNode;
                if(nextNode != null){
                    nextNode.prev = tail;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}