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
    private Map<Integer, Integer> map;
    private int maxFreq;
    private int solve(TreeNode root)
    {
        if(root == null)
        return 0;

        int sum = root.val + solve(root.left) + solve(root.right);

        map.put(sum, map.getOrDefault(sum, 0)+ 1);
        maxFreq = Math.max(maxFreq, map.get(sum));

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) 
    {
        maxFreq = 0;
        map = new HashMap<>();

        // call the dfs
        solve(root);

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            if(entry.getValue() == maxFreq)
            list.add(entry.getKey());
        }

        // convert the list into array and return
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
        result[i] = list.get(i);

        return result;
    }
}