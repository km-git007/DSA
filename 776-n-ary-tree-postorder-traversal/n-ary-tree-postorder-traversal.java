/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public List<Integer> postorder(Node root) 
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
        return ans;

        // Left-to-Right->Root
        // we will add in order Root->Right-to-Left and then reverse the list
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            List<Node> nodeChildren = node.children;

            ans.add(node.val);

            // to add in the order Root->Right-to-Left in the list we must
            // add from left to right in the stack
            for(Node child : nodeChildren)
            stack.push(child);
        }
        // reverse the list and return
        Collections.reverse(ans);
        return ans;
    }
}