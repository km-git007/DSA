class Solution {
    private List<Integer> list;
    private void getLeaves(TreeNode root){
        if(root == null)
        return;

        getLeaves(root.left);

        if(root.left == null && root.right == null)
        list.add(root.val);

        getLeaves(root.right);
    }

    private int index;
    private boolean check(TreeNode root){
        if(root == null)
        return true;

        if(!check(root.left))
        return false;

        if(root.left == null && root.right == null)
        {
            if(index == list.size())
            return false;

            return list.get(index++) == root.val;
        }

        return check(root.right);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        getLeaves(root1);

        index = 0;
        if(!check(root2))
        return false;

        return index == list.size();
    }
}