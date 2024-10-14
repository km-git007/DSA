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
    private int cameras = 0;
    private int installCameras(TreeNode root)
    {
        // 0 --> covered already   1 --> needs a camera   -1 --> has a camera
        if(root == null)    
        return 0;

        int LeftResponse = installCameras(root.left);
        int RightResponse = installCameras(root.right);

        // if any of the node's child needs a camera then we will have to
        // install the camera at this node
        if(LeftResponse == 1 || RightResponse==1)
        {
            cameras++;
            return -1;
        }
        // if both the node's child are already covered then node needs a camera and will ask
        // its parent to fulfill its need.
        if(LeftResponse == 0 && RightResponse == 0)
        return 1;

        // if any of the node's child has a camera then the node is covered by its child.
        // if(LeftResponse == -1 || RightResponse == -1)
        return 0;
    }

    public int minCameraCover(TreeNode root)
    {
        // if root says that it needs a camera then we have to install the camera at the 
        // root since it has no parent to fulfill its need.
        if(installCameras(root) == 1)   
        return cameras + 1;

        return cameras;
    }
}