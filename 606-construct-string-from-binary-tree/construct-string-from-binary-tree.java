class Solution {
    public String tree2str(TreeNode root) {
        if(root == null)
        return "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);
        
        StringBuilder res = new StringBuilder(String.valueOf(root.val));

        if(left.isEmpty() && !right.isEmpty()){
            res.append("(").append(")");
        }

        if(!left.isEmpty()){
            res.append("(").append(left).append(")");
        }

        if(!right.isEmpty()){
            res.append("(").append(right).append(")");
        }

        return res.toString();
    }
}