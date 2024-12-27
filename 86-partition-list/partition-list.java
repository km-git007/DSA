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
    public ListNode partition(ListNode head, int x) 
    {
        if(head == null)
        return head;

        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        while(head != null)
        {
            if(head.val < x)
            {
                leftTail.next = head;
                leftTail = leftTail.next;
            }            
            else
            {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = rightHead.next;
        return leftHead.next; 
    }
}