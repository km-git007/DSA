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
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = head;
        while(curr != null || !stack.isEmpty())
        {
            Node temp = curr;
            if(curr.child != null)
            {
                if(curr.next != null)
                {
                    stack.push(curr.next);
                    curr.next.prev = null;
                }
                // Connect the current node to its child
                curr.next = curr.child;
                curr.child.prev = curr;
                // Clear the child pointer
                curr.child = null;
            }
            curr = curr.next;

            if(curr == null && !stack.isEmpty())
            {
                curr = stack.pop();
                temp.next = curr;
                curr.prev = temp;
            }
        }
        return head;
    }
}