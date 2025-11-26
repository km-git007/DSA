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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while(curr != null){
            ListNode ptr = curr;
            while(curr != null && curr.val == ptr.val){
                curr = curr.next;
            }
            if(curr == ptr.next){
                prev = ptr;
            }else{
                prev.next = curr;
            }
        }
        return dummy.next;
    }
}