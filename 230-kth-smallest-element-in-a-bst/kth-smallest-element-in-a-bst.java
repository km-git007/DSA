class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;
        
        while (curr != null) {
            if (curr.left == null) {
                // Process current node
                count++;
                if (count == k) return curr.val;
                curr = curr.right;
            } else {
                // Find inorder predecessor
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    // Create thread
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    // Remove thread and process current
                    predecessor.right = null;
                    count++;
                    if (count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }
        
        return -1; // Should never reach here
    }
}
