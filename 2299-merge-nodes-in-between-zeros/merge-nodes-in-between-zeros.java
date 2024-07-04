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
    public ListNode mergeNodes(ListNode head) 
    {
        int sum=0;
        ListNode curr=head.next;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(curr!=null)
        {
            if(curr.val==0)
            {
                ListNode node=new ListNode(sum);
                tail.next=node;
                tail=node;
                sum=0;
            }
            sum+=curr.val;
            curr=curr.next;
        }

        return dummy.next;
    }
}