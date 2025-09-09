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
    private Map<Integer, Integer> indexMap;
    private TreeNode solve(int preStart, int preEnd, int postStart, int[] preorder, int[] postorder){
        if(preStart > preEnd)
        return null;

        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
        

        TreeNode root = new TreeNode(preorder[preStart]);

        // next element in preorder is the root of the left subtree
        int leftRootVal = preorder[preStart + 1];

        // find it in postorder
        int leftRootIndex = indexMap.get(leftRootVal);

        // number of nodes in left subtree
        int leftSize = leftRootIndex - postStart + 1;  

        root.left = solve(preStart + 1, preStart + leftSize, postStart, preorder, postorder);
        root.right = solve(preStart + leftSize + 1, preEnd, postStart + leftSize, preorder, postorder);

        return root;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        indexMap = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            indexMap.put(postorder[i], i);
        }
        return solve(0, preorder.length - 1, 0, preorder, postorder);
    }
}