class Solution {
    private ListNode findMiddleNode(ListNode start, ListNode end) {
        ListNode slow = start, fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private TreeNode buildBST(ListNode start, ListNode end) {
        if(start == end) return null;

        // find the middle element
        ListNode middle = findMiddleNode(start, end); 

        // create the new node
        TreeNode newNode = new TreeNode(middle.val);
        
        newNode.left = buildBST(start, middle);
        newNode.right = buildBST(middle.next, end);
        return newNode;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head, null);
    }
}