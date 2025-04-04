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
record Pair(int first, int second) {}
class Solution {

    private Map<Pair, List<TreeNode>> map;
    private List<TreeNode> solve(int start, int end)
    {
        List<TreeNode> res = new ArrayList<>();
        if(start > end)
        {
            res.add(null);
            return res;
        } 

        else if(start == end)
        {
            res.add(new TreeNode(start));
            return res;
        } 

        Pair pair = new Pair(start, end);
        if(map.containsKey(pair))
        return map.get(pair);

        for(int root = start; root <= end; root++)
        {
            var leftBSTs = solve(start, root - 1);
            var rightBSTs = solve(root + 1, end);
            for(TreeNode rightRoot : rightBSTs)
            {
                for(TreeNode leftRoot : leftBSTs)
                {
                    TreeNode node = new TreeNode(root);
                    node.left = leftRoot;
                    node.right = rightRoot;
                    res.add(node);
                }       
            }
        }
        map.put(pair, res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) 
    {
        map = new HashMap<>();
        return solve(1, n);
    }
}