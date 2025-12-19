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
class Solution {
    private ListNode reverse(ListNode head, int steps){
        ListNode prev = null;
        ListNode curr = head;
        while(steps-- > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // make connection
        head.next = curr;
        return prev;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        for(int i = 1; i <= left - 1; i++){
            curr = curr.next;
        }
        curr.next = reverse(curr.next, right - left + 1);
        return dummyHead.next;
    }
}