/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null){
            return;
        }

        if(root.left != null){
            parentMap.put(root.left, root);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
        }

        dfs(root.left, parentMap);
        dfs(root.right, parentMap);
    }

    private List<Integer> bfs(TreeNode target, int k, Map<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while(!queue.isEmpty() && k > 0){
            int  size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null && !visited.contains(node.left)){
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            k--;
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
        }
        return res;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, parentMap);
        return bfs(target, k, parentMap);
    }
}