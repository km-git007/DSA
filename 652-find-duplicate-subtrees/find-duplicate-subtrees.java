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
    private String hasDuplicate(TreeNode root, List<TreeNode> res, Map<String, Integer> map){
        if(root == null){
            return "N";
        }

        String left = hasDuplicate(root.left, res, map);
        String right = hasDuplicate(root.right, res, map);

        String key = String.valueOf(root.val) + "#" + left + "#" + right;
        if(map.containsKey(key) && map.get(key) == 1){
            res.add(root);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        hasDuplicate(root, res, new HashMap<>());
        return res;
    }
}