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
    public Node connect(Node root) {
                if(root == null) return null;
        Node curr = root;
        while(curr.left != null){
            Node start = curr;
            while(start != null){
                start.left.next = start.right;
                if(start.next != null) {
                    start.right.next = start.next.left;
                }
                start = start.next;
            }
            curr = curr.left;
        }
        return root;
    }
}