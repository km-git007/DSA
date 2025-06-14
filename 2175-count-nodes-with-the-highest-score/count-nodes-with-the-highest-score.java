class TreeNode{
    int val;
    TreeNode right, left;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private TreeNode buildTree(int[] parents)
    {
        TreeNode root = new TreeNode(0);
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, root);

        for(int i = 1; i < parents.length; i++)
        {
            int nodeVal = parents[i];
            map.putIfAbsent(nodeVal, new TreeNode(nodeVal));

            TreeNode node = map.get(nodeVal);

            map.putIfAbsent(i, new TreeNode(i));

            if(node.left == null)
            node.left = map.get(i);

            else
            node.right = map.get(i);
        }
        return root;
    }

    private long maxScore = 0; 
    private int totalNodes, count = 0;
    private int dfs(TreeNode root)
    {
        if(root == null)
        return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int rest = totalNodes - left - right - 1;

        long scoreOfNode = 1;
        if (left > 0) scoreOfNode *= left;
        if (right > 0) scoreOfNode *= right;
        if (rest > 0) scoreOfNode *= rest;

        if(scoreOfNode > maxScore) {
            maxScore = scoreOfNode;
            count = 1;
        }else if (scoreOfNode == maxScore) {
            count++;
        }
        return 1 + left + right;
    }

    public int countHighestScoreNodes(int[] parents) 
    {
        TreeNode root = buildTree(parents);
        totalNodes = parents.length;

        dfs(root);
        return count;
    }
}