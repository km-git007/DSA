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

        Node curr = root;
        while(curr.left != null)
        {
            Node node = curr;
            while(node != null)
            {
                // make connection between children
                node.left.next = node.right;

                // make connection between right child and the left child of next node
                if(node.next != null)
                node.right.next = node.next.left;

                node = node.next;
            }
            curr = curr.left;
        }

        return root;
    }
}