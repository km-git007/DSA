class Solution {    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(-1);
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            if(node.val > root.val){
                root = node;
            }
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                node.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }

            stack.push(node);
        }
        
        return root;
    }
}