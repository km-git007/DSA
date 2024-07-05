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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null)
        return head;

        ListNode curr=head,tail=null;
        int length=0;
        while(curr!=null)
        {
            length++;
            tail=curr;
            curr=curr.next;
        }

        k=k%length;
        if(k==0)
        return head;
        
        curr=head;
        for(int i=1;i<length-k;i++)
        curr=curr.next;

        ListNode newHead=curr.next;
        tail.next=head;
        curr.next=null;

        return newHead;
    }
}