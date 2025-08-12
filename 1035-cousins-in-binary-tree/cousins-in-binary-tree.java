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
class Solution {
    private int levelX, levelY;
    private TreeNode parentX, parentY;
    void preorder(TreeNode root, TreeNode parent, int level, int x, int y) {
        if (root == null) {
            return;
        }

        if(root.val == x) {
            levelX = level;
            parentX = parent;
        }

        if(root.val == y) {
            levelY = level;
            parentY = parent;
        }
        preorder(root.left, root, level + 1, x, y);    
        preorder(root.right, root, level + 1, x, y);   
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        preorder(root, null, 0, x, y);
        if(levelX == levelY && parentX != parentY) {
            return true;
        }
        return false;
    }
}