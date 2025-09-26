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
    private void findAllPaths(TreeNode root, List<String> pathList, StringBuilder path) {
        if(root == null) return;

        int length = path.length();
        path.append(root.val);

        if(root.left == null && root.right == null){
            pathList.add(path.toString());
        }
        
        path.append("->");
        findAllPaths(root.left, pathList, path);
        findAllPaths(root.right, pathList, path);
        
        path.setLength(length);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        findAllPaths(root, pathList, new StringBuilder());
        return pathList;
    }
}