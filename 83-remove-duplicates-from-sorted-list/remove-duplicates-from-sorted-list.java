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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, prev = head;
        while(curr != null){
            while(curr != null && curr.val == prev.val){
                curr = curr.next;
            }
            prev.next = curr;
            prev = curr;
        }
        return head;
    }
}