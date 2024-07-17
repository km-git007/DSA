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
    public ListNode reverseList(ListNode curr) 
    {
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;   
    }
    
    public void reorderList(ListNode head) 
    {
        if(head.next==null)
        return;
        
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        ListNode head2=reverseList(slow);
        while(head!=null || head2!=null)
        {
            if(head!=null)
            {
                tail.next=head;
                tail=head;
                head=head.next;
            }
            if(head2!=null)
            {
                tail.next=head2;
                tail=head2;
                head2=head2.next;
            }
        }
        head=dummy.next;
    }
}