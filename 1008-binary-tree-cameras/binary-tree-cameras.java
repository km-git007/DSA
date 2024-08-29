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
    private int cameras;
    private int solve(TreeNode root)
    {
        //  '-1' --> covered   '1' --> has a camera  '0' --> needs a camera
        if(root==null)
        return -1;

        int LeftState=solve(root.left);
        int RightState=solve(root.right);

        if(LeftState==0 || RightState==0)
        {
            cameras++;
            return 1;
        }

        if(LeftState==-1 && RightState==-1)
        return 0;

        // if(LeftState==1 || RightState==1)
        return -1;
    }

    public int minCameraCover(TreeNode root) 
    {
        cameras=0;
        if(solve(root)==0) //root=[0]
        cameras++;   
        return cameras;
    }
}