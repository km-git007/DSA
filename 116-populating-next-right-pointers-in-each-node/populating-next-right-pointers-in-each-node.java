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
        if(root == null || root.left == null)
        return root;

        Node head = root;
        while(root != null)
        {
            Node dummy = new Node(-1);
            Node tail = dummy;
            while(root != null)
            {
                // make connection between children
                if(root.left != null)
                {
                    tail.next = root.left;
                    tail = tail.next;
                }
                
                if(root.right != null)
                {
                    tail.next = root.right;
                    tail = tail.next;
                }

                root = root.next;
            }

            root = dummy.next;
        }

        return head;
    }
}