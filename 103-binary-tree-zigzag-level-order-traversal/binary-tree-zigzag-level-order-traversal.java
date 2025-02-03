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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<>();
        // return empty list if the tree is empty
        if(root == null)
        return result; 
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;
        // Process each level of the tree
        while (!queue.isEmpty()) 
        {
            // number of nodes at current level
            int levelSize = queue.size();  
            List<Integer> list = new ArrayList<>();    
            // Traverse nodes at the current level
            for (int i = 0; i < levelSize; i++) 
            {
                TreeNode current = queue.poll();
                list.add(current.val);
                
                // Add children to the queue for the next level
                if(current.left != null)
                queue.offer(current.left);
                
                if(current.right != null) 
                queue.offer(current.right);
            }

            // if the curr level is odd the reverse the list
            if(level % 2 == 1)
            Collections.reverse(list);

            // Add the current level's list to the result
            result.add(list);

            // increase the level
            level++;
        }
        // return the result
        return result;
    }
}