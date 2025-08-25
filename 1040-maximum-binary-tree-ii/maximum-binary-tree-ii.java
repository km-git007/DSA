class Solution {
    private void inorderTraversal(TreeNode root, List<Integer> nums){
        if(root == null)
        return;

        inorderTraversal(root.left, nums);
        nums.add(root.val);
        inorderTraversal(root.right, nums);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversal(root, nums);
        nums.add(val);
        return constructMaximumBinaryTree(nums.stream().mapToInt(Integer::intValue).toArray());
    }
}