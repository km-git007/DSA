class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        // Queue stores pairs of nodes that should be symmetric
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            // Get a pair of nodes that should be symmetric
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            
            // Both null - continue (symmetric)
            if (leftNode == null && rightNode == null) {
                continue;
            }
            
            // One null, other not - not symmetric
            if (leftNode == null || rightNode == null) {
                return false;
            }
            
            // Different values - not symmetric
            if (leftNode.val != rightNode.val) {
                return false;
            }
            
            // Add children in symmetric order
            // leftNode.left should match rightNode.right
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            
            // leftNode.right should match rightNode.left  
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        
        return true;
    }
}
