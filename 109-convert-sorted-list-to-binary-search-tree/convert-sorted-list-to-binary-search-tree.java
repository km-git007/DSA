/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode[] findMiddleNode(ListNode start) {
        ListNode slow = start, fast = start;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return new ListNode[]{slow, prev};
    }

    private TreeNode buildBST(ListNode start) {
        if(start == null) return null;

        var middleAndPrev = findMiddleNode(start);
        ListNode middle = middleAndPrev[0];
        ListNode prev = middleAndPrev[1];

        // create the new node
        TreeNode newNode = new TreeNode(middle.val);

        if(start == middle){
            return newNode;
        }

        newNode.right = buildBST(middle.next);
        // very essential step
        middle.next = null;
        if(prev != null){
            prev.next = null;
        }
        newNode.left = buildBST(start);

        return newNode;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head);
    }
}