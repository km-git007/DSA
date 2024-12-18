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

    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        int length = 0;
        ListNode curr = head;
        while(curr != null)
        {
            curr = curr.next;
            length++;
        }

        int steps = length - n;

        curr = head;
        while(steps > 0)
        {
            prev = curr;
            curr = curr.next;
            steps--;
        }
        prev.next = curr.next;
        return dummy.next;
    }
}