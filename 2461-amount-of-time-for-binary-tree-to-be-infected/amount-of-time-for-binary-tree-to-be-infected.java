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
    
    private class Pair
    {
        boolean targetFound=false;
        int distance=0;

        Pair(){}

        Pair(int distance,boolean targetFound)
        {
            this.distance=distance;
            this.targetFound=targetFound;
        }
    }

    private int result;
    private Pair solve(TreeNode root,int target)
    {
        if(root==null)
        return new Pair(0,false);

        Pair Left=solve(root.left,target);
        Pair Right=solve(root.right,target);

        if(root.val==target)
        {
            result=Math.max(Left.distance,Right.distance);
            return new Pair(0,true);
        }

        if(Left.targetFound)
        {
            result=Math.max(result,Left.distance+Right.distance+1);
            return new Pair(Left.distance+1,true);
        }

        else if(Right.targetFound)
        {
            result=Math.max(result,Left.distance+Right.distance+1);
            return new Pair(Right.distance+1,true);
        }

        return new Pair(1+Math.max(Left.distance,Right.distance),false);
    }
    
    public int amountOfTime(TreeNode root, int start)
    {
        result=0;
        solve(root,start);
        return result;
    }
}