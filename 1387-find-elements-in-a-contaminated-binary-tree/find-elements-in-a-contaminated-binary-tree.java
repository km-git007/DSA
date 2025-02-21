/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    Set<Integer> set;
    private void bfs(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        set.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = node.val;

            if (node.left != null) {
                node.left.val = 2 * value + 1;
                set.add(node.left.val);
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = 2 * value + 2;
                set.add(node.right.val);
                queue.offer(node.right);
            }
        }
    }

    public FindElements(TreeNode root) 
    {
        set = new HashSet<>();
        bfs(root);
    }

    public boolean find(int target) 
    {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */