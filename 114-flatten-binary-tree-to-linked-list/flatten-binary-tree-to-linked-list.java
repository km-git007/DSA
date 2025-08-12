class Solution {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        
        while (curr != null) {
            // Inner loop: Keep going left, flattening as we go
            while (curr.left != null) {
                // Save right subtree for later processing
                if(curr.right != null) 
                stack.push(curr.right);
                
                // Move left subtree to right position
                curr.right = curr.left;
                curr.left = null;
                
                // Continue with the moved subtree
                curr = curr.right;
            }
            
            if(curr.right == null && !stack.isEmpty())
            curr.right = stack.pop();
    
            curr = curr.right;
        }
    }
}
