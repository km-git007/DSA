class Solution {

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void reverse(List<TreeNode> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            swap(list.get(start), list.get(end));
            start++;
            end--;
        }        
    }
    
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean flag = false;
        List<TreeNode> list;
        while(!queue.isEmpty()){
            int level = queue.size();
            list = new ArrayList<>();
            while(level-- > 0){
                TreeNode node = queue.poll();
                if (flag){
                    list.add(node);
                }
                
                if (node.left != null){
                    queue.add(node.left);
                }
                
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            reverse(list);
            flag = !flag;
        }
        return root;
    }
}