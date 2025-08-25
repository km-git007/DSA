class TreeNode{
    int val;
    TreeNode right, left;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private TreeNode buildTree(int[] parents){
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(0);
        map.put(0, root);
        for(int i = 1; i < parents.length; i++){
            map.putIfAbsent(parents[i], new TreeNode(parents[i]));
            TreeNode parent = map.get(parents[i]);
            
            map.putIfAbsent(i, new TreeNode(i));
            TreeNode child = map.get(i);
            if(parent.left == null){
                parent.left = child;
            }else{
                parent.right = child;
            }
        }
        return root;
    }
    
    private int sizeOfTree(TreeNode root){
        if(root == null) return 0;
        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }
    
    private long maxScore = 0; 
    private int treeSize, count = 0;
    private int dfs(TreeNode root){
        if(root == null) 
        return 0;

        int leftScore = dfs(root.left);
        int rightScore = dfs(root.right);
        int rest = treeSize - leftScore - rightScore - 1;

        long scoreOfNode = 1;
        if (leftScore > 0) scoreOfNode *= leftScore;
        if (rightScore > 0) scoreOfNode *= rightScore;
        if (rest > 0) scoreOfNode *= rest;

        if(scoreOfNode > maxScore){
            maxScore = scoreOfNode;
            count = 1;
        }else if(scoreOfNode == maxScore){
            count++;
        }

        return 1 + leftScore + rightScore;
    }

    public int countHighestScoreNodes(int[] parents) {
        TreeNode root = buildTree(parents);
        treeSize = sizeOfTree(root);
        dfs(root);
        return count;
    }
}