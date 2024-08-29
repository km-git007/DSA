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

    private ListNode reverse(ListNode head)
    {
        ListNode curr=head,prev=null;
        while(curr!=null)
        {
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode originalHead) 
    {
        ListNode head=reverse(originalHead);
        ListNode curr=head,tail=null;
        while(curr!=null)
        {
            if(tail==null || curr.val>=tail.val)
            {
                ListNode node=new ListNode(curr.val);
                node.next=tail;
                tail=node;
            }
            curr=curr.next;
        }
        return tail;
    }
}