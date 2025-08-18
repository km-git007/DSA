class Solution {
    private int findInorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            
            int inorderSuccessor = findInorderSuccessor(root.right);
            root.val = inorderSuccessor;
            root.right = deleteNode(root.right, inorderSuccessor);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}