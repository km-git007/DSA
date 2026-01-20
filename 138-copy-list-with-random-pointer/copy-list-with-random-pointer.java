/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while(curr != null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null) {
            map.get(curr).next = map.get(curr.next);
            if(curr.random != null) {
                map.get(curr).random = map.get(curr.random);
            }
            curr = curr.next;
        }
        return map.get(head);
    }
}