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
    public Solution()
    {
        adjList = new HashMap<>();
        visited = new HashSet<>();
        ans = new ArrayList<>();
    }

    private void buildAdjList(TreeNode root,TreeNode parent)
    {
        if(root == null)
        return;

        if(!adjList.containsKey(root.val))
        adjList.put(root.val,new HashSet<>());

        HashSet<Integer> set=adjList.get(root.val);

        if(parent!=null)
        set.add(parent.val);

        if(root.left != null) 
        set.add(root.left.val);

        if(root.right != null) 
        set.add(root.right.val);

        buildAdjList(root.left,root);
        buildAdjList(root.right,root);
    }
    
    private int K;
    private HashSet<Integer> visited;
    private HashMap<Integer,HashSet<Integer>> adjList;
    List<Integer> ans;
    private void dfs(int node,int steps)
    {
        visited.add(node);
        HashSet<Integer> neighbours=adjList.get(node);
        for(Integer neighbour : neighbours) 
        {
            if(!visited.contains(neighbour))
            dfs(neighbour,steps+1);
        }

        if(steps==K)
        ans.add(node);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        K=k;
        buildAdjList(root,null);
        dfs(target.val,0);
        return ans;
    }
}