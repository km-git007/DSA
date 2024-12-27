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
    public ListNode reverseList(ListNode head,int steps)
    {
        ListNode curr=head;
        ListNode prev=null;
        for(int i=0;i<steps;i++)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        // most important step
        head.next=curr;  
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if(left == right)
        return head;
        
        ListNode dummy=new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        for(int i = 0; i < left - 1; i++)
        curr = curr.next;

        ListNode reversedHead = reverseList(curr.next, right - left + 1);
        curr.next = reversedHead;

        return dummy.next;
    }
}