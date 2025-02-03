/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) 
    {
        if(root == null)
        return root;

        Node curr = root;
        while(curr != null)
        {
            Node dummy = new Node(-1);
            Node tail = dummy;
            while(curr != null)
            {
                if(curr.left != null)
                {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if(curr.right != null)
                {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                // move the current
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}