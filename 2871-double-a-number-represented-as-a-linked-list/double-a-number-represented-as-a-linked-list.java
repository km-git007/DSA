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
    public ListNode doubleIt(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head != null)
        {
            int res = head.val * 2;
            int carry = res /10;

            head.val = res % 10;
            tail.val += carry;

            tail.next = head;
            tail = head;

            head = head.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}