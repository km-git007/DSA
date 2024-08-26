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

    private Deque<Integer> stack=new ArrayDeque<>();
    private void solve(Node root)
    {
        if(root==null)
        return;

        // Node->Right->Left and then reverse the an List.
        stack.add(root.val);

        List<Node> offsprings=root.children;
        // add from right to left in the stack
        for(int i=offsprings.size()-1;i>=0;i--) 
        solve(offsprings.get(i));
    }

    public List<Integer> postorder(Node root) 
    {
        solve(root);
        List<Integer> ans=new ArrayList<>();

        while(!stack.isEmpty())
        ans.add(stack.pop());

        Collections.reverse(ans);
        return ans;
    }
}