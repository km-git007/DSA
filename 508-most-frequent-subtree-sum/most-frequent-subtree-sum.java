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
private Map<Integer, Integer> subtreeSumMap;
    private int maxFrequency;
    private int subtreeSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = root.val + subtreeSum(root.left) + subtreeSum(root.right);
        
        subtreeSumMap.put(sum, subtreeSumMap.getOrDefault(sum, 0) + 1);
        maxFrequency = Math.max(maxFrequency, subtreeSumMap.get(sum));
        
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        maxFrequency = 0;
        subtreeSumMap = new HashMap<>();
        subtreeSum(root);
        
        List<Integer> sumList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : subtreeSumMap.entrySet()) {
            if(maxFrequency == entry.getValue()) {
                sumList.add(entry.getKey());
            }
        }
        return sumList.stream().mapToInt(Integer::intValue).toArray();
    }
}