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
    public List<Integer> preorder(Node root) 
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
        return ans;

        // Root-Left-to-Right
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            List<Node> nodeChildren = node.children;

            ans.add(node.val);

            // to add in the order Root->Left-to-Right in the list we must
            // add from right to left in the stack
            for(int i = nodeChildren.size() - 1; i >= 0; i--)
            stack.push(nodeChildren.get(i));
        }
        return ans;
    }
}